package com.eteration.simplebanking.services;

import com.eteration.simplebanking.controller.ApprovalCodeGenerator;
import com.eteration.simplebanking.exceptions.ErrorMessage;
import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.mapper.AccountMapper;
import com.eteration.simplebanking.mapper.BillPaymentMapper;
import com.eteration.simplebanking.mapper.TransactionMapper;
import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.exceptions.ResourceNotFoundException;
import com.eteration.simplebanking.model.dto.AccountDTO;
import com.eteration.simplebanking.model.dto.BillPaymentDTO;
import com.eteration.simplebanking.model.dto.TransactionDTO;
import com.eteration.simplebanking.model.enums.TransactionType;
import com.eteration.simplebanking.model.request.BillPaymentRequest;
import com.eteration.simplebanking.repository.AccountRepository;
import com.eteration.simplebanking.repository.BillPaymentRepository;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// This class is a place holder you can change the complete implementation
@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private TransactionMapper transactionMapper;
    @Autowired
    private BillPaymentMapper billPaymentMapper;
    @Autowired
    private BillPaymentRepository billPaymentRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository, AccountMapper accountMapper, TransactionMapper transactionMapper, BillPaymentMapper billPaymentMapper, BillPaymentRepository billPaymentRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
        this.billPaymentMapper = billPaymentMapper;
        this.billPaymentRepository = billPaymentRepository;
    }

    private Long getAccountNumber() {
        long smallest = 1000_0000_0000_0000L;
        long biggest = 9999_9999_9999_9999L;
        long random = ThreadLocalRandom.current().nextLong(smallest, biggest);
        return random;
    }

    public Account createAccount(User user) {
        Account account = new Account();
        account.setBalance(new Double(0.0));
        account.setAccountNumber(getAccountNumber().toString());
        account.setOwner(user.getFirstName()+" "+user.getLastName());
        accountRepository.save(account);
        return account;
    }

    public void credit(Double amount, String accountNumber, ApprovalCodeGenerator codeGenerator) throws ResourceNotFoundException {
        Account account = findAccount(accountNumber);
        account.setBalance(account.getBalance()+amount);
        DepositTransaction depositTransaction = new DepositTransaction();
        depositTransaction.setAmount(amount);
        depositTransaction.setType(TransactionType.DEPOSITTRANSACTION.toString());
        depositTransaction.setApprovalCode(codeGenerator.generateRandomUUID());
        List<Transaction> transactions=new ArrayList<>();
        transactions.add(depositTransaction);
        account.setTransactions(transactions);
        Account account1= accountRepository.save(account);
        depositTransaction.setAccount(account1);
        transactionRepository.save((Transaction) depositTransaction);

    }

    public void debit(Double amount, String accountNumber, ApprovalCodeGenerator codeGenerator) throws InsufficientBalanceException, ResourceNotFoundException {
        Account account = findAccount(accountNumber);
        if(amount>account.getBalance()){
            throw new InsufficientBalanceException(
                    String.format(ErrorMessage.INSUFFICIENT_BALANCE, amount));
        }else {
            account.setBalance(account.getBalance()-amount);
        }

        WithdrawalTransaction withdrawalTransaction = new WithdrawalTransaction();
        withdrawalTransaction.setAmount(amount);
        withdrawalTransaction.setType(TransactionType.WITHDRAWALTRANSACTION.toString());
        withdrawalTransaction.setApprovalCode(codeGenerator.generateRandomUUID());
        List<Transaction> transactions=new ArrayList<>();
        transactions.add(withdrawalTransaction);
        account.setTransactions(transactions);
        Account account1= accountRepository.save(account);
        withdrawalTransaction.setAccount(account1);
        transactionRepository.save((Transaction)withdrawalTransaction);
    }

    public Account findAccount(String accountNumber) {
        Account account=null;
        try {
            account= accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->
                    new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, accountNumber)));
        }catch (ResourceNotFoundException e){}

        return account;

    }

    public AccountDTO getAccount(String accountNumber) throws ResourceNotFoundException {
        Account account= accountRepository.findByAccountNumber(accountNumber).orElseThrow(()->
                new ResourceNotFoundException(String.format(ErrorMessage.RESOURCE_NOT_FOUND_MESSAGE, accountNumber)));
        AccountDTO accountDTO=accountMapper.accountToAccountDTO(account);

        return accountDTO;

    }

    public void payment(BillPaymentRequest billPaymentRequest, String accountNumber, ApprovalCodeGenerator codeGenerator) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        if(billPaymentRequest.getAmount()>account.getBalance()){
            throw new InsufficientBalanceException(
                    String.format(ErrorMessage.INSUFFICIENT_BALANCE, billPaymentRequest.getAmount()));
        }else {
            account.setBalance(account.getBalance()-billPaymentRequest.getAmount());
        }
        BillPayment billPayment=new BillPayment();
        billPayment.setAmount(billPaymentRequest.getAmount());
        billPayment.setPhoneCompany(billPaymentRequest.getPhoneCompany());
        billPayment.setPhoneNumber(billPaymentRequest.getPhoneNumber());
        billPayment.setApprovalCode(codeGenerator.generateRandomUUID());
        List<BillPayment> billPayments=new ArrayList<>();
        billPayments.add(billPayment);
        account.setBillPayments(billPayments);
        Account account1= accountRepository.save(account);
        billPayment.setAccount(account1);
        billPaymentRepository.save(billPayment);
    }
}

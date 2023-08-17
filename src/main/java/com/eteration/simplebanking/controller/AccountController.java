package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.exceptions.InsufficientBalanceException;
import com.eteration.simplebanking.exceptions.ResourceNotFoundException;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.model.dto.AccountDTO;
import com.eteration.simplebanking.model.request.BillPaymentRequest;
import com.eteration.simplebanking.model.response.TransactionStatus;
import com.eteration.simplebanking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@RestController
@RequestMapping("/account/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> findAccount(@PathVariable String accountNumber) throws ResourceNotFoundException {
        return ResponseEntity.ok(accountService.getAccount(accountNumber));
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction depositTransaction) throws ResourceNotFoundException {
        ApprovalCodeGenerator codeGenerator=new ApprovalCodeGenerator();
        accountService.credit(depositTransaction.getAmount(), accountNumber,codeGenerator);
        TransactionStatus status = new TransactionStatus("OK",codeGenerator.generateRandomUUID());
        return ResponseEntity.ok(status);
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction withdrawalTransaction) throws InsufficientBalanceException, ResourceNotFoundException {
        ApprovalCodeGenerator codeGenerator=new ApprovalCodeGenerator();
        accountService.debit(withdrawalTransaction.getAmount(),accountNumber,codeGenerator);
        TransactionStatus status = new TransactionStatus("OK",codeGenerator.generateRandomUUID());
        return ResponseEntity.ok(status);
	}

    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.findAccount(accountNumber));
    }

    @PostMapping("/payment/{accountNumber}")
    public ResponseEntity<TransactionStatus> billPayment(@PathVariable String accountNumber, @RequestBody BillPaymentRequest billPaymentRequest) throws InsufficientBalanceException {
        ApprovalCodeGenerator codeGenerator=new ApprovalCodeGenerator();
        accountService.payment(billPaymentRequest,accountNumber,codeGenerator);
        TransactionStatus status = new TransactionStatus("OK",codeGenerator.generateRandomUUID());
        return ResponseEntity.ok(status);
    }
}
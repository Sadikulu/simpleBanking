package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    public TransactionService() {
    }

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    private TransactionRepository transactionRepository;

    public List<Transaction> findAllTransaction(Long accountId){
        List<Transaction> transactions=transactionRepository.findAllByAccount_Id(accountId);
        return transactions;
    }
}

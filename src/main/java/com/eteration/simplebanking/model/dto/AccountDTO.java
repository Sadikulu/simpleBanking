package com.eteration.simplebanking.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccountDTO {
    private String owner;
    private String accountNumber;
    private Double balance;
    private LocalDateTime createDte;
    private List<TransactionDTO> transactions=new ArrayList();
    private List<BillPaymentDTO> billPayments=new ArrayList();

    public List<BillPaymentDTO> getBillPayments() {
        return billPayments;
    }

    public void setBillPayments(List<BillPaymentDTO> billPayments) {
        this.billPayments = billPayments;
    }

    public AccountDTO() {
    }

    public AccountDTO(String owner, String accountNumber, Double balance, LocalDateTime createDte, List<TransactionDTO> transactions, List<BillPaymentDTO> billPayments) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDte = createDte;
        this.transactions = transactions;
        this.billPayments = billPayments;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreateDte() {
        return createDte;
    }

    public void setCreateDte(LocalDateTime createDte) {
        this.createDte = createDte;
    }

    public List<TransactionDTO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDTO> transactions) {
        this.transactions = transactions;
    }
}

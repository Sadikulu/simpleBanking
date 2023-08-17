package com.eteration.simplebanking.model;

// This class is a place holder you can change the complete implementation

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    public Account(Long id, String owner, String accountNumber, Double balance, LocalDateTime createDte, List<Transaction> transactions, List<BillPayment> billPayments) {
        this.id = id;
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createDte = createDte;
        this.transactions = transactions;
        this.billPayments = billPayments;
    }

    public Account() {

    }

    public Account(String keremKaraca, String number) {
    }

    public Long getId() {
        return id;
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<BillPayment> getBillPayments() {
        return billPayments;
    }

    public void setBillPayments(List<BillPayment> billPayments) {
        this.billPayments = billPayments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private String accountNumber;
    private Double balance;
    private LocalDateTime createDte=LocalDateTime.now();
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions=new ArrayList();
    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<BillPayment> billPayments=new ArrayList();

    public void deposit(int i) {
    }

    public void withdraw(int i) {
    }

    public void post(DepositTransaction depositTrx) {
    }
    public void post(WithdrawalTransaction withdrawalTrx) {
    }
}

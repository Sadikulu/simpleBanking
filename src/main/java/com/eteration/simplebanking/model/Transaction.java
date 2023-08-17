package com.eteration.simplebanking.model;

import javax.persistence.*;
import java.time.LocalDateTime;

// This class is a place holder you can change the complete implementation
@Entity
public abstract class Transaction {
    public Transaction() {
    }

    public Transaction(Long id, LocalDateTime date, Double amount, String approvalCode, Account account) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Transaction(Double amount, String codeGenerator) {
    }

    public Transaction(Double amount) {
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDateTime date=LocalDateTime.now();
    protected Double amount;
    protected String approvalCode;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    protected String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

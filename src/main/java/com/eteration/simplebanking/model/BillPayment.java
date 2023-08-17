package com.eteration.simplebanking.model;

import com.eteration.simplebanking.model.enums.TransactionType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BillPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneCompany;
    private String phoneNumber;
    private Double amount;
    private String approvalCode;
    private LocalDateTime createDate=LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private TransactionType type= TransactionType.BILLPAYMENTTRANSACTION;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Long getId() {
        return id;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public TransactionType getType() {
        return type;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public BillPayment() {
    }

    public BillPayment(Long id, String phoneCompany, String phoneNumber, Double amount, String approvalCode, LocalDateTime createDate, TransactionType type, Account account) {
        this.id = id;
        this.phoneCompany = phoneCompany;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.createDate = createDate;
        this.type = type;
        this.account = account;
    }
}

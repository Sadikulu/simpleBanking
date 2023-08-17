package com.eteration.simplebanking.model.dto;

import com.eteration.simplebanking.model.enums.TransactionType;

import java.time.LocalDateTime;

public class BillPaymentDTO {
    private String phoneCompany;
    private String phoneNumber;
    private Double amount;
    private String approvalCode;
    private LocalDateTime createDate;
    private TransactionType type;

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

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public BillPaymentDTO(String phoneCompany, String phoneNumber, Double amount, String approvalCode, LocalDateTime createDate, TransactionType type) {
        this.phoneCompany = phoneCompany;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.createDate = createDate;
        this.type = type;
    }

    public BillPaymentDTO() {
    }
}

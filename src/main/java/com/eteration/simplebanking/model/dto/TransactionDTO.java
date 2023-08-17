package com.eteration.simplebanking.model.dto;

import java.time.LocalDateTime;

public class TransactionDTO {
    private LocalDateTime date;
    private Double amount;
    private String approvalCode;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TransactionDTO() {
    }

    public TransactionDTO(LocalDateTime date, Double amount, String approvalCode, String type) {
        this.date = date;
        this.amount = amount;
        this.approvalCode = approvalCode;
        this.type = type;
    }

    public TransactionDTO(LocalDateTime date, Double amount, String approvalCode) {
        this.date = date;
        this.amount = amount;
        this.approvalCode = approvalCode;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
}

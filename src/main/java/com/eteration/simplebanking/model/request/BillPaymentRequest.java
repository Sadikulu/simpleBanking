package com.eteration.simplebanking.model.request;

public class BillPaymentRequest {
    private String phoneCompany;
    private String phoneNumber;
    private Double amount;

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

    public BillPaymentRequest(String phoneCompany, String phoneNumber, Double amount) {
        this.phoneCompany = phoneCompany;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public BillPaymentRequest() {
    }
}

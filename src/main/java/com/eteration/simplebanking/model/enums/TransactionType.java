package com.eteration.simplebanking.model.enums;

public enum TransactionType {
    WITHDRAWALTRANSACTION("WithdrawalTransaction"),
    DEPOSITTRANSACTION("DepositTransaction"),
    BILLPAYMENTTRANSACTION("BillPaymentTransaction");

    private String status;

    private TransactionType(String status) {
        this.status=status;
    }

    public String getName() {
        return status;
    }

}

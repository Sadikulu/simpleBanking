package com.eteration.simplebanking.model;

import com.eteration.simplebanking.model.enums.TransactionType;

import javax.persistence.*;

// This class is a place holder you can change the complete implementation
@Entity
public class WithdrawalTransaction extends Transaction{
    public WithdrawalTransaction() {
    }

    public WithdrawalTransaction(String type) {
        this.type = type;
    }

    public WithdrawalTransaction(double v) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Enumerated(EnumType.STRING)
    private String type= TransactionType.WITHDRAWALTRANSACTION.toString();

}



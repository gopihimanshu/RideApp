package com.allstate.exceptions;


public class TransactionMoney extends Exception {
    public TransactionMoney(){}

    public TransactionMoney(String message){
        super(message);
    }
}

package com.example.bank_login2.dataAccess.models;

import android.accounts.Account;

import java.util.Date;

public class Transaction {
    private Date date;
    private Account sender, receiver;
    private long amount;

    public Transaction(Date date, Account sender, Account receiver, long amount) {
        this.date = date;
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    public Transaction() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
        this.receiver = receiver;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

package com.programzilla.login.dataAccess.models;

public class Account {
    private int accNumber;
    private long saldo;

    public Account(int accNumber, long saldo) {
        this.accNumber = accNumber;
        this.saldo = saldo;
    }

    public Account() {
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}

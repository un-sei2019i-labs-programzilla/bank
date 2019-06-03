package com.programzilla.login.dataAccess.models;

public class Customer extends User {

    private Account acc;
    private int pass;

    public Customer(String name, int id, Account acc, int pass) {
        super(name, id);
        this.acc = acc;
        this.pass = pass;
    }

    public Customer(String name, int id) {
        super(name, id);
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}

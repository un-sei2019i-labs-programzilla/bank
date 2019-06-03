package com.programzilla.login.dataAccess.models;

public class Admin extends User {
    private String pass;

    public Admin(String name, int id, String pass) {
        super(name, id);
        this.pass = pass;
    }

    public Admin(String name, int id) {
        super(name, id);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

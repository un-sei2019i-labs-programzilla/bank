package com.example.bank_login2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.bank_login2.dataAccess.controllers.controllerTransaction;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;
import com.example.bank_login2.dataAccess.models.Transaction;
import com.example.bank_login2.dataAccess.repositories.UserRepository;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserRepository userRep = new UserRepository();
        Account juanAccount = new Account(1018484010, 100000) ;
        Account pepeAccount = new Account(1234567890, 150000);
        Customer sender = new Customer("JUAN", 1, juanAccount, 123456);
        Customer receiver = new Customer("PEPE", 2, pepeAccount, 123456);
        Date date = new Date();
        Transaction transaction = new Transaction(date, juanAccount, pepeAccount, 50000);
        controllerTransaction send = new controllerTransaction();
        send.sendMoney(this, transaction, juanAccount, pepeAccount);

    }




}

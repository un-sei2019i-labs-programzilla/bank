package com.example.bank_login2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;
import com.example.bank_login2.dataAccess.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserRepository userRep = new UserRepository();
        Account newAccount = new Account(1018484010, 400000) ;
        Customer newCustomer = new Customer("JUAN", 1, newAccount, 123456);
        userRep.getUSerByID(this, 1);
    }




}

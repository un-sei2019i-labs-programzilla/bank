package com.example.bank_login2;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.bank_login2.dataAccess.controllers.controllerTransaction;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;
import com.example.bank_login2.dataAccess.models.Transaction;
import com.example.bank_login2.dataAccess.repositories.UserRepository;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText username,password;
    public static final String EXTRA_MESSAGE = "com.example.bank_login2.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);

        UserRepository userRep = new UserRepository();
        Account newAccount = new Account(123232134, 600000) ;
        Customer newCustomer = new Customer("JUAN", 1, newAccount, 123456);
        userRep.addUser(this ,newCustomer,newAccount);


         newCustomer = new Customer("Pedro", 2, newAccount, 45678);
        Account newAccount2 = new Account(1018484010, 400000) ;
        userRep.addUser(this ,newCustomer,newAccount2);

        Date date = new Date();
        Transaction send = new Transaction(date, newAccount, newAccount2, 50000);

        controllerTransaction transaction = new controllerTransaction();
        transaction.sendMoney(this, send, newAccount, newAccount2);

    }

    public void Login(View view) {
        String nom,pass;
        nom = username.getText().toString();
        pass= password.getText().toString();
        UserRepository userRep = new UserRepository();

        if ( userRep.comp(this,nom,pass)){
            Intent intent = new Intent(this, menu.class);
            EditText editText = (EditText) findViewById(R.id.username);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario no existe", Toast.LENGTH_LONG).show();
        }
    }


}

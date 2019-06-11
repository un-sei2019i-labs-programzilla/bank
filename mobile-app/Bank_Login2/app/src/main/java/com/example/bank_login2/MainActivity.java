package com.example.bank_login2;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;
import com.example.bank_login2.dataAccess.repositories.UserRepository;

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
        Account newAccount = new Account(1018484010, 400000) ;
        Customer newCustomer = new Customer("JUAN", 1, newAccount, 123456);
        userRep.addUser(this ,newCustomer,newAccount);


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
        }
    }


}

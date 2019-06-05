package com.example.bank_login2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import repositories.user;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user.add(this, 3, "asdkasdjas", 1234);

    }




}

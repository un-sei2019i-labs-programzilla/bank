package com.programzilla.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.programzilla.login.R;

import com.programzilla.login.dataAccess.SQLite_OpenHelper;

public class MainActivity extends AppCompatActivity{

    Button logInButton ;
    SQLite_OpenHelper helper = new  SQLite_OpenHelper(this, "BD1", null, 1);


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper.open();
        helper.insertReg("JuanSe","1234","jussilvaca","123456");


        logInButton = (Button)findViewById(R.id.button3);
        logInButton.setOnClickListener(new View.OnClickListener()
           {
               public void onClick(View v){
                   EditText idEditText =(EditText) findViewById(R.id.editText);
                   EditText paswordEditText =(EditText) findViewById(R.id.editText2);

                   try{
                       Cursor cursor = helper.validateCredentials(idEditText.getText().toString(), paswordEditText.getText().toString());
                       if(cursor.getCount()>0){
                           Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
                           ////// startActivity(new Intent(MainActivity.this, SuccessfulLogin.class));
                           // Intent i = new Intent(getApplicationContext(), FailedLogin.class);
                       }else{
                           ///// startActivity(new Intent(MainActivity.this, FailedLogin.class));
                       }
                       idEditText.setText("");
                       paswordEditText.setText("");
                       idEditText.findFocus();
                   }catch(SQLException e){
                       Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                       e.printStackTrace();
                   }
                   helper.closeDataBase();
               }
           }
        );

    }
}
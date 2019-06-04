package com.example.bank_login2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import dataAcces.Database;

public class MainActivity extends AppCompatActivity {

    Database db = new Database(this, "DATABASE BANK", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add(2, "asdkasdjas", 1234);
        read(1);
    }

    public void add(int id, String name, int password){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NOMBRE", name);
        values.put("PASSWORD", password);
        database.insert("USER", null,  values);
        database.close();
    }

    public void read(int id){
        SQLiteDatabase database = db.getReadableDatabase();
        String[] projection = {"ID", "NOMBRE", "PASSWORD"};

        Cursor cursor = database.query("USER", projection, "id = ?", new String[] {String.valueOf(id)},
                null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        Toast.makeText(this, cursor.getString(1) + " " + cursor.getString(2), Toast.LENGTH_LONG).show();
        db.close();

    }
}

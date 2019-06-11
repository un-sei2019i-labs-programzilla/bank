package com.example.bank_login2.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper{

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USER (ID INTEGER PRIMARY KEY, NAME TEXT NOT NULL," +
                " PASSWORD INTEGER NOT NULL, ACCOUNT_NUMBER INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE CUENTA (ACCOUNT_NUMBER INTEGER PRIMARY KEY, SALDO INTEGER NOT NULL," +
                "FOREIGN KEY (ACCOUNT_NUMBER) REFERENCES USER(ACCOUNT_NUMBER))");
        db.execSQL("CREATE TABLE ADMIN(ID INTEGER PRIMARY KEY, PASSWORD TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

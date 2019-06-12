package com.example.bank_login2.dataAccess.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_login2.dataAccess.database.Database;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Transaction;

public class controllerTransaction {

    public void sendMoney(Context context, Transaction transaction, Account sender, Account receiver) {
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        Cursor c = database.query("cuenta", new String[]{"account_number", "saldo"}, "ACCOUNT_NUMBER = ?",
                new String[] {Integer.toString(sender.getAccNumber())}, null, null, null);
        Cursor c2 = database.query("cuenta", new String[]{"account_number", "saldo"}, "ACCOUNT_NUMBER = ?",
                new String[] {Integer.toString(receiver.getAccNumber())}, null, null, null);
        if(c.moveToFirst()){
            if(c2.moveToFirst()) {
                if (c.getInt(0) == sender.getAccNumber() && c.getLong(1) - transaction.getAmount() >= 0) {
                    ContentValues values = new ContentValues();
                    values.put("SALDO", c.getInt(1) - transaction.getAmount());
                    database.update("CUENTA", values, "ACCOUNT_NUMBER = " + sender.getAccNumber(), null);
                    ContentValues values1 = new ContentValues();
                    values1.put("SALDO", c2.getInt(1) + transaction.getAmount());
                    database.update("CUENTA", values1, "ACCOUNT_NUMBER = "+receiver.getAccNumber(), null);
                }
            }
        }

        database.close();
    }
}
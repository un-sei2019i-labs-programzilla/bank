package com.example.bank_login2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.bank_login2.dataAccess.database.Database;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;

public class AccountRepository {
    public void addAccount(Context context, Customer customer, Account account){
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", customer.getId());
        values.put("NAME", customer.getName());
        values.put("PASSWORD", customer.getPass());
        values.put("ACCOUNT_NUMBER", account.getAccNumber());
        database.insert("ACCOUNT", null, values);
        database.close();
    }

    public void deleteAccount(Context context, int id){
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        database.delete("ACCOUNT", "ID = "+id, null);
        database.close();
    }

}

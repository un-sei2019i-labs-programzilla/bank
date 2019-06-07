package com.example.bank_login2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.bank_login2.dataAccess.database.Database;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;

public class UserRepository {
    Context context;
    Database db = new Database(context, "DB1", null, 1);

    public void addUser(Context context, Customer customer, Account account){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", customer.getId());
        values.put("NAME", customer.getName());
        values.put("PASSWORD", customer.getPass());
        values.put("ACCOUNT_NUMBER", account.getAccNumber());
        database.insert("USER", null, values);
        database.close();
    }

    public void updateUserbyID(Context context, int id, String newName, int newPassword, int newAccountNumber ){
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NAME", newName);
        values.put("PASSWORD", newPassword);
        values.put("ACCOUNT_NUMBER",newAccountNumber);
        database.update("USER", values, "ID ="+id, null);
        database.close();
    }

}

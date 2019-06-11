package com.example.bank_login2.dataAccess.repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.bank_login2.dataAccess.database.Database;
import com.example.bank_login2.dataAccess.models.Account;
import com.example.bank_login2.dataAccess.models.Customer;
import com.example.bank_login2.dataAccess.models.User;

public class UserRepository {



    public void addUser(Context context, Customer customer, Account account){
        Database db = new Database(context, "DB1", null, 1);
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
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NAME", newName);
        values.put("PASSWORD", newPassword);
        values.put("ACCOUNT_NUMBER",newAccountNumber);
        database.update("USER", values, "ID = "+id, null);
        database.close();
    }

    public void deleteUserByID(Context context, int id){
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        database.delete("USER", "ID = "+id, null);
        database.close();
    }

    public void getUSerByID(Context context, int id) {
        Database db = new Database(context, "BD1", null, 1);
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor cursor = database.query("USER", new String[]{"NAME", "ACCOUNT_NUMBER", "PASSWORD"},
                "ID = ?", new String [] {Integer.toString(id)}, null, null, null);
        if (cursor.moveToFirst()){

            Toast.makeText(context, (cursor.getString(0) + " " + cursor.getString(1)
                + " " + cursor.getString(2)), Toast.LENGTH_LONG).show();
        }
        database.close();
    }

}

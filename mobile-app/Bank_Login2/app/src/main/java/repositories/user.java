package repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import dataAcces.Database;

public class user {

    public static void add(Context context, int id, String name, int password){
        Database db = new Database(context, "DB1", null, 1);
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID", id);
        values.put("NOMBRE", name);
        values.put("PASSWORD", password);
        database.insert("USER", null,  values);
        database.close();
    }

    public static void read(Context context, int id){
        Database db = new Database(context, "BD1", null, 1);
        SQLiteDatabase database = db.getReadableDatabase();
        String[] projection = {"ID", "NOMBRE", "PASSWORD"};

        Cursor cursor = database.query("USER", projection, "id = ?", new String[] {String.valueOf(id)},
                null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        Toast.makeText(context, cursor.getString(1) + " " + cursor.getString(2), Toast.LENGTH_LONG).show();
        database.close();

    }


}

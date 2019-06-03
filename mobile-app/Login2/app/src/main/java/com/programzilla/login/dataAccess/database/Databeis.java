package com.programzilla.login.dataAccess.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Databeis extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="DB";
    public static  final  String TABLE_NAME = "BANK";
    public static final  String COLUMN_NAME = "NAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";

    public Databeis(Context applicationContext, String bd1, Context context, int i){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
     public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME+ "(" + COLUMN_NAME + "TEXT, "+COLUMN_PASSWORD+"TEXT)" );
     }

     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
     }

}

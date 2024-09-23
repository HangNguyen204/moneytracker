package com.example.moneytracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    static final String Data_base_name = "Account.DB";
    static final int DataBase_ver = 1;

    static final String DataBase_Table = "User";//crete a user table
    static final String User_id = "ID";
    static final String User_email = "Email";
    static final  String User_password = "Password";

    private static final String Create_DB_Query = "CREATE TABLE " + DataBase_Table + " ( " + User_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + User_email + " TEXT NOT NULL, " + User_password + " TEXT NOT NULL ); ";

    public DataBaseHelper( Context context) {
        super(context, Data_base_name, null, DataBase_ver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_DB_Query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DataBase_Table);
    }
}

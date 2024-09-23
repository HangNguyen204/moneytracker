package com.example.moneytracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLDataException;

public class DataBaseManager {
    private DataBaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DataBaseManager(Context ctx){
        context = ctx;
    }
    public  DataBaseManager open() throws SQLDataException {
        dbHelper = new DataBaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return  this;
    }
    public void close(){
        dbHelper.close();
    }
    public void insert(String user_email, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.User_email, user_email);
        contentValues.put(DataBaseHelper.User_password, password);
        database.insert(DataBaseHelper.DataBase_Table, null, contentValues);
    }
    public Cursor fetch(){
        String [] columns = new String[] {DataBaseHelper.User_id, DataBaseHelper.User_email, DataBaseHelper.User_password};
        Cursor cursor = database.query(DataBaseHelper.DataBase_Table,columns, null, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
    public int update(long _id, String userEmail, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.User_email, userEmail);
        contentValues.put(DataBaseHelper.User_password, password);
        int ret = database.update(DataBaseHelper.DataBase_Table, contentValues, DataBaseHelper.User_id + "=" + _id, null);
        return ret;
    }

    public void delete(long _id){
        database.delete(DataBaseHelper.DataBase_Table, DataBaseHelper.User_id + "=" + _id, null);
    }
}

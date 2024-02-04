package net.com.gopal.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelp extends SQLiteOpenHelper {
    public static final String dbname = "database.db";

    public DatabaseHelp(@Nullable Context context) {
        super(context, dbname, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Customer (Username TEXT, Phone_Number TEXT, Email TEXT, Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Customer");
        onCreate(db);
    }

    public boolean insertData(String Username, String Phone_number, String Email, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Username", Username);
        cv.put("Phone_number", Phone_number);
        cv.put("Email", Email);
        cv.put("Password", Password);

        long insert = db.insert("Customer", null, cv);
        return insert != -1;
    }

    public boolean checkUsername(String Username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Customer WHERE Username=?", new String[]{Username});
//        cursor.close();
        return cursor.getCount() > 0;
    }


    public boolean checkUserPassword(String Username, String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Customer WHERE Username=? AND Password=?", new String[]{Username, Password});
//        cursor.close();
        return cursor.getCount() > 0;
    }
}


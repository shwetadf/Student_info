package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super( context, "Info.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Student_info(ENTER_NAME text,ENTER_SURNAME text,ENTER_CLASS text,ENTER_ROLL_NUMBER text,ENTER_GRADE text,ENTER_CONTACT_NUMBER text)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Student_info");

    }

    public boolean insert(String Enter_name, String Enter_surname, String Enter_class, String Enter_roll_number, String Enter_grade, String Enter_contact_number) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ENTER_NAME", Enter_name);
        contentValues.put("ENTER_SURNAME", Enter_surname);
        contentValues.put("ENTER_CLASS", Enter_class);
        contentValues.put("ENTER_ROLL_NUMBER", Enter_roll_number);
        contentValues.put("ENTER_GRADE", Enter_grade);
        contentValues.put("ENTER_CONTACT_NUMBER", Enter_contact_number);
        long result = sqLiteDatabase.insert("Student_info", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    Cursor readAllData()
    {
        Cursor cursor;
        SQLiteDatabase db=this.getReadableDatabase();

            cursor = db.rawQuery("SELECT ENTER_NAME,ENTER_SURNAME,ENTER_CLASS,ENTER_ROLL_NUMBER,ENTER_GRADE,ENTER_CONTACT_NUMBER FROM Student_info", null);

        return cursor;
    }
}

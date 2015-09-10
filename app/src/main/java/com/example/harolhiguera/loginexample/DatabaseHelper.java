package com.example.harolhiguera.loginexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    //DB creation
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contacts.db";
    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_UNAME = "uname";
    private static final String COLUMN_PASS = "pass";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "CREATE TABLE contacts (id integer primary key NOT NULL , "+
            "name text NOT NULL , email text NOT NULL , uname text NOT NULL , pass text not NULL );";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    /* This method will insert the contact data into the database the data comes from the object created in Sign Up */
    public void insertContact(Contact c){
        db = this.getReadableDatabase();


        ContentValues values = new ContentValues();
        String query = "Select * from contacts";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();


        values.put(COLUMN_ID, count);
        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        db.insert(TABLE_NAME, null, values);
        db.close();
        Log.i("there", "I am here");

    }

    /* This method first grabs the two columns: uname and pass, then it checks every element on
     * uname and if exists in the database it will return rhe password stored if not jus a message */
    public String searchPass(String uname){
        db = this.getReadableDatabase();
        String query = "select uname, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        String a, b;
        b = "Username not Found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                if (a.equals(uname)) {
                    b = cursor.getString(1);
                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXIST" + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}

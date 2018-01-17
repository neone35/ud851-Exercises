package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// COMPLETE (1) extend the SQLiteOpenHelper class
public class WaitlistDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "waitlist.db";
    public static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tableName = WaitlistContract.WaitlistEntry.TABLE_NAME;
        String tableColumnID = WaitlistContract.WaitlistEntry._ID;
        String guestName = WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME;
        String partySize = WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE;
        String timeStamp = WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP;

        String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " +
                tableName + " (" +
                tableColumnID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                guestName + " TEXT NOT NULL," +
                partySize + " INTEGER NOT NULL," +
                timeStamp + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String tableName = WaitlistContract.WaitlistEntry.TABLE_NAME;
        String SQL_DROP_WAITLIST_TABLE = "DROP TABLE IF EXISTS " + tableName;
        sqLiteDatabase.execSQL(SQL_DROP_WAITLIST_TABLE);
        onCreate(sqLiteDatabase);
    }

    // COMPLETE (2) Create a static final String called DATABASE_NAME and set it to "waitlist.db"

    // COMPLETE (3) Create a static final int called DATABASE_VERSION and set it to 1

    // COMPLETE (4) Create a Constructor that takes a context and calls the parent constructor

    // COMPLETE (5) Override the onCreate method

    // COMPLETE (6) Inside, create an String query called SQL_CREATE_WAITLIST_TABLE that will create the table

    // COMPLETE (7) Execute the query by calling execSQL on sqLiteDatabase and pass the string query SQL_CREATE_WAITLIST_TABLE

    // COMPLETE (8) Override the onUpgrade method

    // COMPLETE (9) Inside, execute a drop table query, and then call onCreate to re-create it

}
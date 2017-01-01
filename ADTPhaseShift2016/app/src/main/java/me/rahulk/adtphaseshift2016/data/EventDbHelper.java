package me.rahulk.adtphaseshift2016.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import me.rahulk.adtphaseshift2016.Event;

/**
 * Created by rahulcomp24 on 10/09/16.
 */
public class EventDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = EventDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "phaseshift.db";
    private static final int DATABASE_VERSION = 2;

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_EVENT_TABLE =  "CREATE TABLE " + EventContract.EventEntry.TABLE_NAME + " ("
                + EventContract.EventEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EventContract.EventEntry.COLUMNS_EVENT_TITLE + " TEXT NOT NULL UNIQUE, "
                + EventContract.EventEntry.COLUMNS_EVENT_DEPARTMENT + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_TYPE + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_BMSCE + " INTEGER NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_FULL + " INTEGER NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_PRIZE1 + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_PRIZE2 + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_VENUE + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_PERSON + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_PERSON_NUMBER + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_FEES + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_DATE + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_TIME + " TEXT NOT NULL, "
                + EventContract.EventEntry.COLUMNS_EVENT_DESCRIPTION + " TEXT NOT NULL, "
                + "UNIQUE (" + EventContract.EventEntry.COLUMNS_EVENT_TITLE + ") ON CONFLICT REPLACE);";

        Log.v("CREAET TABLE QUERY ", SQL_CREATE_EVENT_TABLE);

        sqLiteDatabase.execSQL(SQL_CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EventContract.EventEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}

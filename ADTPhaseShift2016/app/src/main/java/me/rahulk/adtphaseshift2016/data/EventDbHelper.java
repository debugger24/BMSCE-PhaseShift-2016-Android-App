package me.rahulk.adtphaseshift2016.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import me.rahulk.adtphaseshift2016.Event;

/**
 * Created by rahulcomp24 on 10/09/16.
 */
public class EventDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = EventDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "phaseshift.db";
    private static final int DATABASE_VERSION = 1;

    public EventDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_EVENT_TABLE =  "CREATE TABLE " + EventContract.EventList.TABLE_NAME + " ("
                + EventContract.EventList._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EventContract.EventList.COLUMNS_EVENT_TITLE + " TEXT NOT NULL UNIQUE, "
                + EventContract.EventList.COLUMNS_EVENT_DEPARTMENT + " TEXT NOT NULL, "
                + EventContract.EventList.COLUMNS_EVENT_DESCRIPTION + " TEXT NOT NULL);";

        sqLiteDatabase.execSQL(SQL_CREATE_EVENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

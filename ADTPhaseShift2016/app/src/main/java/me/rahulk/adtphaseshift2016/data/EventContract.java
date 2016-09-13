package me.rahulk.adtphaseshift2016.data;

import android.provider.BaseColumns;

/**
 * Created by rahulcomp24 on 10/09/16.
 */

public class EventContract {
    public static final class EventList implements BaseColumns {
        public static final String TABLE_NAME = "events";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMNS_EVENT_TITLE = "title";
        public static final String COLUMNS_EVENT_DEPARTMENT = "department";
        public static final String COLUMNS_EVENT_DESCRIPTION = "description";
    }
}

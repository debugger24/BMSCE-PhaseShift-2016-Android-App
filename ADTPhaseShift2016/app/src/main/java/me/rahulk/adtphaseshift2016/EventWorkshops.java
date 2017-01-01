package me.rahulk.adtphaseshift2016;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import me.rahulk.adtphaseshift2016.adapter.EventCursorAdapter;
import me.rahulk.adtphaseshift2016.data.EventContract;


public class EventWorkshops extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>{

    private EventCursorAdapter eventCursorAdapter;
    private static final int FORECAST_LOADER = 1;

    private static final String[] EVENT_COLUMNS = {
            EventContract.EventEntry._ID,
            EventContract.EventEntry.COLUMNS_EVENT_TITLE,
            EventContract.EventEntry.COLUMNS_EVENT_DEPARTMENT,
            EventContract.EventEntry.COLUMNS_EVENT_BMSCE,
            EventContract.EventEntry.COLUMNS_EVENT_FULL,
    };

    static final int COL_EVENT_ID = 0;
    static final int COL_EVENT_TITLE = 1;
    static final int COL_EVENT_DEPARTMENT = 2;
    static final int COL_EVENT_BMSCE = 3;
    static final int COL_EVENT_FULL = 4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_event_workshops, container, false);
        ListView listView = (ListView) rootview.findViewById(R.id.lstEvent);

        eventCursorAdapter = new EventCursorAdapter(getActivity(), null, 0);

        listView.setAdapter(eventCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Cursor cursor = (Cursor) adapterView.getItemAtPosition(position);
                if (cursor != null) {
                    Intent intent = new Intent(getActivity(), EventDetails.class).setData(EventContract.EventEntry.buildEventDetailUri(cursor.getLong(COL_EVENT_ID)));
                    startActivity(intent);
                }
            }
        });

        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(1, null, this);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String sortOrder = EventContract.EventEntry.COLUMNS_EVENT_DEPARTMENT + " ASC";
        Uri allEvents = EventContract.EventEntry.buildEventUri();
        String selection = EventContract.EventEntry.COLUMNS_EVENT_TYPE + " = ?";
        String[] selectionArgs = {"Workshop"};
        return new CursorLoader(getActivity(),allEvents,EVENT_COLUMNS, selection , selectionArgs, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        eventCursorAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        eventCursorAdapter.swapCursor(null);
    }
}

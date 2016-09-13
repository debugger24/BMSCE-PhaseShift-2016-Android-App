package me.rahulk.adtphaseshift2016.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import me.rahulk.adtphaseshift2016.R;

/**
 * Created by rahulcomp24 on 11/09/16.
 */
public class EventCursorAdapter extends CursorAdapter {
    public EventCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_event, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtTitle = (TextView) view.findViewById(R.id.title);
        TextView txtDepartment = (TextView) view.findViewById(R.id.department);

        txtTitle.setText(cursor.getString(cursor.getColumnIndexOrThrow("title")));
        txtDepartment.setText(cursor.getString(cursor.getColumnIndexOrThrow("department")));

    }
}

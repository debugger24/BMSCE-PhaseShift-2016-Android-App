package me.rahulk.adtphaseshift2016.adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import me.rahulk.adtphaseshift2016.R;

/**
 * Created by rahulcomp24 on 11/09/16.
 */
public class EventCursorAdapter extends CursorAdapter {
    private int bmsce;
    public EventCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_event, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView eventTitle = (TextView) view.findViewById(R.id.title);
        eventTitle.setText(cursor.getString(cursor.getColumnIndexOrThrow("title")));

        TextView eventDepartment = (TextView) view.findViewById(R.id.department);
        eventDepartment.setText(cursor.getString(cursor.getColumnIndexOrThrow("department")));


        bmsce = cursor.getInt(cursor.getColumnIndexOrThrow("bmsce"));

        ImageView alert1 = (ImageView) view.findViewById(R.id.alert1);

        if(bmsce == 1) {
            alert1.setVisibility(View.VISIBLE);
        }
        else {
            alert1.setVisibility(View.GONE);
        }
    }
}

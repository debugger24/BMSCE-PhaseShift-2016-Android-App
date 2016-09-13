package me.rahulk.adtphaseshift2016.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import me.rahulk.adtphaseshift2016.Contact;
import me.rahulk.adtphaseshift2016.Event;
import me.rahulk.adtphaseshift2016.R;

/**
 * Created by rahulcomp24 on 12/09/16.
 */
public class EventAdapter extends ArrayAdapter<Event>{
    Event event;

    public EventAdapter(Context context, List<Event> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_event, parent, false);
        }

        event = getItem(position);

        TextView eventTitle = (TextView) listItemView.findViewById(R.id.title);
        eventTitle.setText(event.getTitle());

        TextView eventDepartment = (TextView) listItemView.findViewById(R.id.department);
        eventDepartment.setText(event.getDepartment());

        ImageView bmsceImage = (ImageView) listItemView.findViewById(R.id.bmsce);
        if(event.getBMSCE()) {
            Log.v("FOUND ", event.getTitle());
            bmsceImage.setVisibility(View.VISIBLE);
        }
        else {
            bmsceImage.setVisibility(View.GONE);
        }



//        View callButton = listItemView.findViewById(R.id.call);

//        callButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Contact currentContact = getItem(position);
//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:" + currentContact.getMobileNumber()));
//                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                    // TODO: Consider calling
//                    Toast.makeText(getContext(), "Failed : Required Permission to Call", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                getContext().startActivity(callIntent);
//            }
//        });

        return listItemView;
    }
}

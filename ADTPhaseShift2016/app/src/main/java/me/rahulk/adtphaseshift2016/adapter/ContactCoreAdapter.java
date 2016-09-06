package me.rahulk.adtphaseshift2016.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import me.rahulk.adtphaseshift2016.Contact;
import me.rahulk.adtphaseshift2016.R;

/**
 * Created by rahulcomp24 on 06/09/16.
 */
public class ContactCoreAdapter extends ArrayAdapter<Contact> {
    Contact contact;

    public ContactCoreAdapter(Context context, List<Contact> contacts) {
        super(context, 0, contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        YourWrapper wrapper = null;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
            wrapper = new YourWrapper(listItemView);
            listItemView.setTag(wrapper);
        } else {
            wrapper = (YourWrapper) listItemView.getTag();
        }

        contact = getItem(position);

        wrapper.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + contact.getMobileNumber()));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    Toast.makeText(getContext(), "Failed : Required Permission to Call", Toast.LENGTH_SHORT).show();
                    return;
                }
                getContext().startActivity(callIntent);
            }
        });

        TextView contactName = (TextView) listItemView.findViewById(R.id.contactName);
        contactName.setText(contact.getName());

        TextView contactNumber = (TextView) listItemView.findViewById(R.id.contactNumber);
        contactNumber.setText(contact.getMobileNumber());

        return listItemView;
    }
}

class YourWrapper
{
    private View base;
    private ImageView imageButton;

    public YourWrapper(View base)
    {
        this.base = base;
    }

    public ImageView getButton()
    {
        if (imageButton == null)
        {
            imageButton = (ImageView) base.findViewById(R.id.call);
        }
        return (imageButton);
    }
}

package me.rahulk.adtphaseshift2016.adapter;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        View listItemView;
        if(position == 6) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_social, parent, false);

            View emailButton = listItemView.findViewById(R.id.emailButton);
            emailButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"phaseshift.bmsce@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "ADT PhaseShift 2016");
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                }
            });

            View fbButton = listItemView.findViewById(R.id.fbButton);
            fbButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri webpage = Uri.parse("https://www.facebook.com/techfest.bmsce");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                }
            });

            View twitterButton = listItemView.findViewById(R.id.twitterButton);
            twitterButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri webpage = Uri.parse("https://twitter.com/techfest_bmsce");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                }
            });

            View instaButton = listItemView.findViewById(R.id.instaButton);
            instaButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri webpage = Uri.parse("https://www.instagram.com/techfest_bmsce");
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                        getContext().startActivity(intent);
                    }
                }
            });
        }

        else {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);

            contact = getItem(position);

            TextView contactName = (TextView) listItemView.findViewById(R.id.contactName);
            contactName.setText(contact.getName());

            TextView contactNumber = (TextView) listItemView.findViewById(R.id.contactNumber);
            contactNumber.setText(contact.getMobileNumber());

            View callButton = listItemView.findViewById(R.id.call);

            callButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Contact currentContact = getItem(position);
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:" + currentContact.getMobileNumber()));
                    if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        Toast.makeText(getContext(), "Failed : Required Permission to Call", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    getContext().startActivity(callIntent);
                }
            });
        }
        return listItemView;
    }
}

package me.rahulk.adtphaseshift2016;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import me.rahulk.adtphaseshift2016.data.EventContract;

public class EventDetails extends ActionBarActivity implements LoaderCallbacks<Cursor>{
    private  TextView txtTitle, txtDepartment, txtPrize1, txtPrize2, txtVenue, txtCal, txtCoordinator, txtFees, txtDesctiption;
    private  View layoutPrize1, layoutPrize2;
    View forBMSCE, fullEvent;
    private String shareMessage = "Shared using PhaseShift App";

    private static final int DETAIL_LOADER = 0;
    private static final String[] EVENT_COLUMNS = {
            EventContract.EventEntry._ID,
            EventContract.EventEntry.COLUMNS_EVENT_TITLE,
            EventContract.EventEntry.COLUMNS_EVENT_DEPARTMENT,
            EventContract.EventEntry.COLUMNS_EVENT_PRIZE1,
            EventContract.EventEntry.COLUMNS_EVENT_PRIZE2,
            EventContract.EventEntry.COLUMNS_EVENT_BMSCE,
            EventContract.EventEntry.COLUMNS_EVENT_FULL,
            EventContract.EventEntry.COLUMNS_EVENT_VENUE,
            EventContract.EventEntry.COLUMNS_EVENT_DATE,
            EventContract.EventEntry.COLUMNS_EVENT_TIME,
            EventContract.EventEntry.COLUMNS_EVENT_PERSON,
            EventContract.EventEntry.COLUMNS_EVENT_PERSON_NUMBER,
            EventContract.EventEntry.COLUMNS_EVENT_DESCRIPTION,
            EventContract.EventEntry.COLUMNS_EVENT_FEES
    };

    static final int COL_EVENT_ID = 0;
    static final int COL_EVENT_TITLE = 1;
    static final int COL_EVENT_DEPARTMENT = 2;
    static final int COL_EVENT_PRIZE1 = 3;
    static final int COL_EVENT_PRIZE2 = 4;
    static final int COL_EVENT_BMSCE = 5;
    static final int COL_EVENT_FULL = 6;
    static final int COL_EVENT_VENUE = 7;
    static final int COL_EVENT_DATE = 8;
    static final int COL_EVENT_TIME = 9;
    static final int COL_EVENT_PERSON = 10;
    static final int COL_EVENT_PERSON_NUMBER = 11;
    static final int COL_EVENT_DESCRIPTION = 12;
    static final int COL_EVENT_FEES = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportLoaderManager().initLoader(DETAIL_LOADER, null, this);


        txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtDepartment = (TextView) findViewById(R.id.txtDepartment);
        txtPrize1 = (TextView) findViewById(R.id.txtPrize1);
        txtPrize2 = (TextView) findViewById(R.id.txtPrize2);
        txtVenue = (TextView) findViewById(R.id.txtVenue);
        txtCal = (TextView) findViewById(R.id.txtCal);
        txtCoordinator = (TextView) findViewById(R.id.txtCoordinator);
        txtFees = (TextView) findViewById(R.id.txtFees);
        txtDesctiption = (TextView) findViewById(R.id.txtDescription);

        layoutPrize1 = (View) findViewById(R.id.layoutPrize1);
        layoutPrize2 = (View) findViewById(R.id.layoutPrize2);

        forBMSCE = (View) findViewById(R.id.forBMSCE);
        fullEvent = (View) findViewById(R.id.fullEvent);

        if (ContextCompat.checkSelfPermission(EventDetails.this,
                android.Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(EventDetails.this,
                    android.Manifest.permission.CALL_PHONE)) {

            } else {

                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(EventDetails.this,
                        new String[]{android.Manifest.permission.CALL_PHONE},
                        1);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_share:
                shareEvent();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void shareEvent() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Intent intent = this.getIntent();
        if (intent == null) {
            return null;
        }
        Uri data = intent.getData();
        return new CursorLoader(this, data, EVENT_COLUMNS, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, final Cursor data) {

        if (!data.moveToFirst()) { return; }

        txtTitle.setText(data.getString(COL_EVENT_TITLE));
        txtDepartment.setText(data.getString(COL_EVENT_DEPARTMENT));

        if(!data.getString(COL_EVENT_PRIZE1).equals("NA")) {
            layoutPrize1.setVisibility(View.VISIBLE);
            txtPrize1.setText("Winner\n" + data.getString(COL_EVENT_PRIZE1));
        }
        else {
            layoutPrize1.setVisibility(View.GONE);
        }

        if(!data.getString(COL_EVENT_PRIZE2).equals("NA")) {
            layoutPrize2.setVisibility(View.VISIBLE);
            txtPrize2.setText("Runner Up\n" + data.getString(COL_EVENT_PRIZE2));
        }
        else {
            layoutPrize2.setVisibility(View.GONE);
        }

        txtVenue.setText(data.getString(COL_EVENT_VENUE));
        txtCal.setText(data.getString(COL_EVENT_DATE) + "\n" + data.getString(COL_EVENT_TIME));

        txtCoordinator.setText("Coordinator" + "\n" + data.getString(COL_EVENT_PERSON) + "\n" + data.getString(COL_EVENT_PERSON_NUMBER));
        txtFees.setText("Registration Fees" + "\n" + data.getString(COL_EVENT_FEES));

        txtDesctiption.setText(data.getString(COL_EVENT_DESCRIPTION));

        if(data.getInt(COL_EVENT_BMSCE) == 1) {
            Log.v("DATA BMSCE", String.valueOf(data.getInt(COL_EVENT_BMSCE)));
            forBMSCE.setVisibility(View.VISIBLE);
        }
        else {
            Log.v("DATA BMSCE", String.valueOf(data.getInt(COL_EVENT_BMSCE)));
            forBMSCE.setVisibility(View.GONE);
        }

        if(data.getInt(COL_EVENT_FULL) == 1) {
            fullEvent.setVisibility(View.VISIBLE);
            Log.v("EVENT FULL", "EVENT FULL");
        }
        else {
            fullEvent.setVisibility(View.GONE);
        }

        txtCoordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + data.getString(COL_EVENT_PERSON_NUMBER)));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    Toast.makeText(getApplicationContext(), "Failed : Require Permission to Call", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(callIntent);
            }
        });

        this.setTitle(data.getString(COL_EVENT_TITLE));

        shareMessage = data.getString(COL_EVENT_TITLE) + "\n\n" + data.getString(COL_EVENT_DESCRIPTION) + "\n\nContact : " + data.getString(COL_EVENT_PERSON) + " (" + data.getString(COL_EVENT_PERSON_NUMBER) + ")\n\nShared using PhaseShift App\n#PhaseShift2016";
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

//    private void register(final int eventID, final int userID) {
//
//        final ProgressDialog progressDialog = new ProgressDialog(EventDetails.this,
//                R.style.AppTheme_Dark_Dialog);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Registering...");
//        progressDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_EVENT_REGISTER, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Log.d(TAG, "Register Response: " + response.toString());
//                try {
//                    JSONObject jObj = new JSONObject(response);
//                    Log.v("REG JSON RESPONSE", jObj.toString());
//                    boolean error = jObj.getBoolean("error");
//                    if(!error) {
//                        Toast.makeText(getApplicationContext(), "Successfully Registered for Event. Check your mail for details", Toast.LENGTH_LONG).show();
//                    }
//                    else {
//                        String errorMsg = jObj.getString("error_msg");
//                        Log.v("Error", errorMsg);
//                        Toast.makeText(getApplicationContext(), errorMsg , Toast.LENGTH_LONG).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                    Toast.makeText(getApplicationContext(), "Something went wrong, Please contact admin." , Toast.LENGTH_LONG).show();
//                }
//                finally {
//                    progressDialog.dismiss();
//                }
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//                Log.e(TAG, "Registration Error: " + volleyError.getMessage());
//                progressDialog.dismiss();
//                Toast.makeText(getApplicationContext(), "Something went wrong, Please contact admin." , Toast.LENGTH_LONG).show();
//            }
//        }) {
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting params to register url
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("eventID", String.valueOf(eventID));
//                params.put("userID", String.valueOf(userID));
//                return params;
//            }
//        };
//        AppController.getInstance().addToRequestQueue(strReq, "Register");
//    }
}

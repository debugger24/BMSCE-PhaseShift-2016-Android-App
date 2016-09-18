package me.rahulk.adtphaseshift2016;

import android.*;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import me.rahulk.adtphaseshift2016.app.AppController;

public class EventDetails extends AppCompatActivity {
    private static final String TAG = "Event Register";
    private  TextView txtTitle, txtDepartment, txtPrize1, txtPrize2, txtVenue, txtCal, txtCoordinator, txtFees, txtDesctiption;
    private  View layoutPrize1, layoutPrize2;
    private Event event;
    private SessionManager session;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Intent intent = getIntent();
        event = (Event) intent.getSerializableExtra("details");

        getSupportActionBar().setTitle(event.getTitle());

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

//        btnRegister = (Button) findViewById(R.id.btnRegister);

        //imageView = (ImageView) findViewById(R.id.eventCover);

        //imageView.setImageResource(R.drawable.cover50);

        View forBMSCE = findViewById(R.id.forBMSCE);

        session = new SessionManager(getApplicationContext());

        txtTitle.setText(event.getTitle());
        txtDepartment.setText(event.getDepartment());

        if(!event.getPrize1().equals("nil") && !event.getPrize2().equals("nil")) {

        }

        if(!event.getPrize1().toLowerCase().equals("nil")) {
            layoutPrize1.setVisibility(View.VISIBLE);
            txtPrize1.setText("Winner\n" + event.getPrize1());
        }
        else {
            layoutPrize1.setVisibility(View.GONE);
        }

        if(!event.getPrize2().toLowerCase().equals("nil")) {
            layoutPrize2.setVisibility(View.VISIBLE);
            txtPrize2.setText("Runner Up\n" + event.getPrize2());
        }
        else {
            layoutPrize2.setVisibility(View.GONE);
        }

        txtVenue.setText(event.getVenue());
        txtCal.setText(event.getDate() + "\n" + event.getTime());

        txtCoordinator.setText("Coordinator" + "\n" + event.getCoordinator() + "\n" + event.getCoordinatorNumber());
        txtFees.setText("Registration Fees" + "\n" + event.getRegFees());

        txtDesctiption.setText(event.getDescription());

        if(event.getBMSCE()) {
            forBMSCE.setVisibility(View.VISIBLE);
        }
        else {
            forBMSCE.setVisibility(View.GONE);
        }

        txtCoordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + event.getCoordinatorNumber()));
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    Toast.makeText(getApplicationContext(), "Failed : Require Permission to Call", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(callIntent);
            }
        });

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
        sendIntent.putExtra(Intent.EXTRA_TEXT, getEventDetails());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private String getEventDetails() {
        return event.getTitle() + "\n\n" + event.getDescription() + "\n\n" + "Venue : " + event.getVenue() + "\n" + event.getDate() + "\n" + event.getTime() + "\n\n" + "Contact : " + event.getCoordinator() + " (" + event.getCoordinatorNumber() + ")" + "\n\n" + "#PhaseShift2016";
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

package me.rahulk.adtphaseshift2016;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import me.rahulk.adtphaseshift2016.app.AppController;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

    private EditText txtName;
    private EditText txtEmail;
    private EditText txtPassword;
    private EditText txtMobile;
    private EditText txtCollege;

    private Button btnSignup;
    private TextView loginLink;

    private String name;
    private String email;
    private String password;
    private String mobile;
    private String college;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txtName = (EditText) findViewById(R.id.input_name);
        txtEmail = (EditText) findViewById(R.id.input_email);
        txtPassword = (EditText) findViewById(R.id.input_password);
        txtMobile = (EditText) findViewById(R.id.input_mobile);
        txtCollege = (EditText) findViewById(R.id.input_college);

        btnSignup = (Button) findViewById(R.id.btn_signup);
        loginLink = (TextView) findViewById(R.id.link_login);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void signup() {
        if (!validate()) {
            onSignupFailed();
            return;
        }

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        name = txtName.getText().toString();
        email = txtEmail.getText().toString();
        password = txtPassword.getText().toString();
        mobile = txtMobile.getText().toString();
        college = txtCollege.getText().toString();

        StringRequest strReq = new StringRequest(Request.Method.POST, AppConfig.URL_REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                try {
                    JSONObject jObj = new JSONObject(response);
                    Log.v("REG JSON RESPONSE", jObj.toString());
                    boolean error = jObj.getBoolean("error");
                    if(!error) {
                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();
                        onSignupSuccess();
                    }
                    else {
                        String errorMsg = jObj.getString("error_msg");
                        Log.v("Error", errorMsg);
                        onSignupFailed();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    onSignupFailed();
                }
                finally {
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, "Registration Error: " + volleyError.getMessage());
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
                onSignupFailed();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("password", password);
                params.put("mobile", mobile);
                params.put("college", college);

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq, "Register");
    }

    private void onSignupSuccess() {
        btnSignup.setEnabled(true);
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Signup Failed", Toast.LENGTH_LONG).show();
        btnSignup.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = txtName.getText().toString();
        String email = txtEmail.getText().toString();
        String password = txtPassword.getText().toString();
        String mobile = txtMobile.getText().toString();
        String college = txtCollege.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            txtName.setError("at least 3 characters");
            valid = false;
        } else {
            txtName.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            txtEmail.setError("enter a valid email address");
            valid = false;
        } else {
            txtEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            txtPassword.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            txtPassword.setError(null);
        }

        if (mobile.isEmpty() || !Patterns.PHONE.matcher(mobile).matches()) {
            txtMobile.setError("invalid mobile number");
            valid = false;
        } else {
            txtMobile.setError(null);
        }

        if (college.isEmpty() || college.length() < 3) {
            txtCollege.setError("at least 3 characters");
            valid = false;
        } else {
            txtCollege.setError(null);
        }

        return valid;
    }
}

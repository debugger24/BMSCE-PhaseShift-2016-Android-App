package me.rahulk.adtphaseshift2016;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by rahulcomp24 on 07/09/16.
 */
public class SessionManager {

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
    Context _context;

    private static final String PREF_NAME = "PhaseShift2016";
    private static final String KEY_IS_LOGGEDIN = "isLoggedIn";
    private static final String KEY_NAME = "NameKey";
    private static final String KEY_Eamil = "EmailKey";

    private final String TAG = "PS SESSION MANAGEMENT";


    public SessionManager(Context context) {
        this._context = context;
        sharedpreferences = _context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }

    public void setLogin(boolean isLoggedIn) {
        editor.putBoolean(KEY_IS_LOGGEDIN, isLoggedIn);
        editor.commit();
        Log.d(TAG, "User login session modified!");
    }

    public void setLoginDetails(String name, String email) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_Eamil, email);
        editor.commit();
        Log.v(TAG, "UserDetails Set");
    }

    public String getName() {
        return sharedpreferences.getString(KEY_NAME, "");
    }

    public String getEmail() {
        return sharedpreferences.getString(KEY_Eamil, "");
    }

    public boolean isLoggedIn(){
        return sharedpreferences.getBoolean(KEY_IS_LOGGEDIN, false);
    }
}

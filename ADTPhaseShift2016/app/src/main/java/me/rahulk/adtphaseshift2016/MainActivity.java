package me.rahulk.adtphaseshift2016;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NewsFeed.OnFragmentInteractionListener, Events.OnFragmentInteractionListener, ContactCore.OnFragmentInteractionListener, AboutPhaseShift.OnFragmentInteractionListener, EventMap.OnFragmentInteractionListener, ContactFragment.OnFragmentInteractionListener, ContactEmergency.OnFragmentInteractionListener, MeetDeveloper.OnFragmentInteractionListener {

    private SessionManager session;
    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        name = session.getName();
        email = session.getEmail();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View header = navigationView.getHeaderView(0);
        TextView txtName = (TextView) header.findViewById(R.id.userName);
        txtName.setText(name);
        TextView txtEmail = (TextView) header.findViewById(R.id.email);
        txtEmail.setText(email);
    }

    private void logoutUser() {
        session.setLogin(false);
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.nav_map) {
            launchMap();
            return true;
        }

        Fragment fragment = null;
        Class fragmentClass = null;
        if (id == R.id.nav_about) {
            fragmentClass = AboutPhaseShift.class;
        }
        else if (id == R.id.nav_newsfeed) {
            fragmentClass = NewsFeed.class;
        }
        else if (id == R.id.nav_events) {
            fragmentClass = Events.class;
        }
        else if (id == R.id.nav_contact) {
            fragmentClass = ContactFragment.class;
        }
        else if( id == R.id.nav_aboutDev) {
            fragmentClass = MeetDeveloper.class;
        }
        else if (id == R.id.nav_logout) {
            logoutUser();
        }
        else {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFrame, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchMap() {
        Intent intent = new Intent(MainActivity.this, MapActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

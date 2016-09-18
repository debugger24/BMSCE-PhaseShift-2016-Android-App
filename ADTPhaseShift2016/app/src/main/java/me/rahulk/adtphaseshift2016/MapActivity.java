package me.rahulk.adtphaseshift2016;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.kml.KmlLayer;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback, AdapterView.OnItemSelectedListener {

    private GoogleMap mMap;
    LatLng locationMarker;
    ArrayList<EventLocation> eventLocations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        eventLocations = new ArrayList<>();
        eventLocations.add(new EventLocation(12.94071, 77.56591, "Indoor Stadium", 17, "Ground Floor"));
        eventLocations.add(new EventLocation(12.94167, 77.56575, "PG 6004 (EE)", 17, "6th Flood PG Block - Use Stairs / Lift"));
        eventLocations.add(new EventLocation(12.94169, 77.5656, "MV Hall", 17, "1st Flood PG Block - Use Stairs / Lift"));
        eventLocations.add(new EventLocation(12.94245, 77.56594, "Internet Lab", 17, "Ground Floor - ECE Block"));
        eventLocations.add(new EventLocation(12.941577, 77.565998, "MCA Lab", 17, "First Floor - PG Block"));
        eventLocations.add(new EventLocation(12.941764, 77.565520, "BSN Hall", 17, "Ground Floor - PG Block"));
        eventLocations.add(new EventLocation(12.941486, 77.566018, "CS-5005", 17, "5th Floor PG Block - Use Stairs / Lift"));
        eventLocations.add(new EventLocation(12.941506, 77.566084, "CS-5004", 17, "5th Floor PG Block - Use Stairs / Lift"));
        eventLocations.add(new EventLocation(12.941567, 77.566097, "CS-5003", 17, "5th Floor PG Block - Use Stairs / Lift"));
        eventLocations.add(new EventLocation(12.941689, 77.565756, "CR 3001", 17, "Third Floor - ECE Block"));
        eventLocations.add(new EventLocation(12.941692, 77.565799, "CR 3002", 17, "Third Floor - ECE Block"));


//        Spinner spinner = (Spinner) findViewById(R.id.location_spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.location_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                // mMap.clear();
//                EventLocation currentLocation = eventLocations.get(position);
//                locationMarker = new LatLng(currentLocation.getLat(), currentLocation.getLon());
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(locationMarker).zoom(currentLocation.getZoomLevel()).build();
//                mMap.addMarker(new MarkerOptions().position(locationMarker).title(currentLocation.getTitle()).snippet(currentLocation.getLocationDescription())).showInfoWindow();
//                mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parentView) {
//
//            }
//
//        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(12.9418, 77.5661))
                .zoom(17).build();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.9418, 77.5661)).title("PhaseShift 2016 @ BMSCE")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.940729, 77.565993)).title("Indoor Stadium")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.941670, 77.565803)).title("PG Block")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.940954, 77.565393)).title("Danger : Construction Area")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.942307, 77.565921)).title("ECE Block")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.940170, 77.565409)).title("Multi Purpose Hall")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.942255, 77.566306)).title("Classroom Block")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.942289, 77.566662)).title("Library Auditorium")).showInfoWindow();
        mMap.addMarker(new MarkerOptions().position(new LatLng(12.942360, 77.565458)).title("Mech Block")).showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        try {
            KmlLayer layer = new KmlLayer(mMap, R.raw.bmsce, getApplicationContext());
            layer.addLayerToMap();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocationManager lm = (LocationManager)getApplicationContext().getSystemService(getApplicationContext().LOCATION_SERVICE);
        boolean gps_enabled = false;
        boolean network_enabled = false;

        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch(Exception ex) {}


        if(!gps_enabled) {
            Toast.makeText(getApplicationContext(), "Please switch on GPS for better experience", Toast.LENGTH_SHORT).show();
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(getApplicationContext(), "LOCATION ACCESS DENIED", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "Switch", Toast.LENGTH_SHORT).show();
            mMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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
        }

        return super.onOptionsItemSelected(item);
    }
}

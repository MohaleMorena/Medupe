package com.example.medupe;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.core.Context;

import java.io.IOException;
import java.util.List;

public class DoctorLocalisation extends Fragment implements OnMapReadyCallBack {
    private GoogleMap mMap;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView(R.layout.activity_doctor_localisation);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync( (OnMapReadyCallback) this );

    }

    private void setContentView(int activity_doctor_localisation) {
    }

    private FragmentManager getSupportFragmentManager() {
        return null;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Intent intent = null;
        intent = getIntent();
        String address = intent.getStringExtra("address");
        String city = intent.getStringExtra("city");
        LatLng location = getLocationFromAddress(DoctorLocalisation.this, address+", "+city);
        mMap.addMarker(new MarkerOptions ().position(location).title("Marker in "+city));
        mMap.moveCamera( CameraUpdateFactory.newLatLng(location));
    }

    private Intent getIntent() {
        return null;
    }

    public LatLng getLocationFromAddress(DoctorLocalisation context, String strAddress) {

        Geocoder coder = new Geocoder (context );
        List < Address > address;
        LatLng p1 = null;

        try {
            // May throw an IOException
            address = coder.getFromLocationName(strAddress, 5);
            if (address == null) {
                return null;
            }

            Address location = address.get(0);
            p1 = new LatLng(location.getLatitude(), location.getLongitude() );

        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return p1;
    }
}

package com.example.fooddelivery;


import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fooddelivery.NearByClasses.GetNearbyPlacesData;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.libraries.places.compat.Place;
import com.google.android.libraries.places.compat.ui.PlaceAutocompleteFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.compat.ui.PlaceSelectionListener;



public class nearbyActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng rabat = new LatLng(34.01325, -6.83255);
    private static final int PROXIMITY_RADIUS_METERS = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        SupportMapFragment supportMapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        setupAutoCompleteFragment();
    }





    private void setupAutoCompleteFragment() {
        String url = getUrl(rabat.latitude, rabat.longitude, "");
        Object[] DataTransfer = new Object[2];
        DataTransfer[0] = mMap;
        DataTransfer[1] = url;
        Log.d("onClick", url);
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
        getNearbyPlacesData.execute(DataTransfer);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rabat, 8.5f));
        mMap.addMarker(new MarkerOptions()
                .position(rabat)
                .title("rabat")
                .snippet("lokasi saya")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
    }

    private String getUrl(double latitude, double longitude, String nearbyPlace) {
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS_METERS);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + getString(R.string.map_key));
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMap != null) {
            mMap.clear();
        }
    }

}
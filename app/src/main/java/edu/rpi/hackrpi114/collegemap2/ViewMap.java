package edu.rpi.hackrpi114.collegemap2;

import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ViewMap extends FragmentActivity implements OnMapReadyCallback {



    private ArrayList<Building> getBuildings (String college)
    {
        SQLiteDatabase db = openOrCreateDatabase("AllBuildings.db",MODE_PRIVATE,null);
        Cursor c= db.rawQuery("SELECT * FROM " + college,null);
        ArrayList<Building> buildings = new ArrayList<>();
        if(c.moveToFirst()) {
            do {
                Building building = new Building();
                building.building_name = c.getString(0);
                building.building_name = c.getString(1);
                building.latitude = Double.parseDouble(c.getString(2));
                building.longitude = Double.parseDouble(c.getString(3));
                String allTags = c.getString(4);
                building.tags = allTags.split(" ");

                buildings.add(building);
// Adding contact to list
            } while (c.moveToNext());
        }
        return buildings;
    }

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        // Add a marker in Sydney and move the camera
        LatLng rpi = new LatLng(42.7302, -73.6788);
        ArrayList<Building> building_info = getBuildings("RPI");
        /*
        for(int i = 0; i< building_info.size();i++){
            LatLng build_loc = new LatLng(building_info.get(i).latitude,building_info.get(i).longitude);
            mMap.addMarker(new MarkerOptions().position(build_loc).title(building_info.get(i).building_name));
        }*/
        mMap.addMarker(new MarkerOptions().position(rpi).title("RPI"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rpi,15));


    }
}

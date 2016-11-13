package edu.rpi.hackrpi114.collegemap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
    }
    public void viewMap(View view) //TO VIEW THE GOOGLE MAPS
    {
        Intent intent = new Intent(this,ViewMap.class);
        startActivity(intent);
    }
    public void presetTour(View view)
    {
        Intent intent = new Intent(this,presetTour.class); //"this" specifies transition from first screen to next.
        startActivity(intent);
    }
    public void rankedTour(View view)
    {
        Intent intent = new Intent(this,rankedTour.class);
        startActivity(intent);
    }
    public void findLocation(View view)
    {
        Intent intent = new Intent(this,findLocation.class); //"this" specifies transition from first screen to next.
        startActivity(intent);
    }
    public void Credits(View view) //TO LOAD CREDITS
    {
        Intent intent = new Intent(this,credits.class);
        startActivity(intent);
    }
    public void AddBuilding(View view)
    {
        Intent intent = new Intent(this,AddBuilding.class);
        startActivity(intent);
    }
}

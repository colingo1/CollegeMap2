package edu.rpi.hackrpi114.collegemap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void nextActivity(View view)
    {
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }
    public void loadCredits(View view)
    {
        Intent intent = new Intent(this,credits.class); //"this" specifies transition from first screen to next.
        startActivity(intent);
    }
}

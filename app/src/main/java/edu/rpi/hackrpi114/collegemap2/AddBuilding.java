package edu.rpi.hackrpi114.collegemap2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddBuilding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_building);
    }
    void submitAdd(View view)
    {
        String college = ((EditText)findViewById(R.id.CollegeBox)).getText().toString();
        String building_name = ((EditText)findViewById(R.id.NameBox)).getText().toString();
        String description = ((EditText)findViewById(R.id.DescBox)).getText().toString();
        String latitude = ((EditText)findViewById(R.id.LatBox)).getText().toString();
        String longitude = ((EditText)findViewById(R.id.LongBox)).getText().toString();
        String allTags = ((EditText)findViewById(R.id.TagBox)).getText().toString();
        SQLiteDatabase db = openOrCreateDatabase("AllBuildings.db",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + college + " (Name varchar(255), Description varchar(255)," +
                " Latitude varchar(255), Longitude varchar(255), AllTags varchar(255) )");
        String query = "INSERT INTO " + college +
                " VALUES ('" + building_name + "', '"+ description + "', '" + latitude + "', '" + longitude + "', '" + allTags + "')";
        System.out.println(query);
        db.execSQL(query);
    }
}

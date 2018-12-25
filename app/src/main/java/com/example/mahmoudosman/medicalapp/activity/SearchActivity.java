package com.example.mahmoudosman.medicalapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mahmoudosman.medicalapp.R;

public class SearchActivity extends AppCompatActivity {

    TextView next;
    Spinner espicalistsSpinnner,areas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        next=findViewById(R.id.next_step_address);
        espicalistsSpinnner=findViewById(R.id.espicalists);
        areas=findViewById(R.id.areaSpinner);


        String[] espicalists=getResources().getStringArray(R.array.espicalists);
        String[] countries=getResources().getStringArray(R.array.array_countries);


        ArrayAdapter<String> adapterEspicalists = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, espicalists);
        ArrayAdapter<String> adapterArear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries);

        espicalistsSpinnner.setAdapter(adapterEspicalists);
        areas.setAdapter(adapterArear);

    }



    public void goToDoctorList(View view){
        Intent intent= new Intent(SearchActivity.this,DoctorListActivity.class);
        startActivity(intent);
    }
}

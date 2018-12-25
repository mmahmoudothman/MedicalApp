package com.example.mahmoudosman.medicalapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoudosman.medicalapp.R;

public class SearchActivity extends AppCompatActivity {

    TextView next;
    Spinner espicalistsSpinnner, areas;
    static String itemArea="";
    static String itemEspical="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        next = findViewById(R.id.next_step_address);
        espicalistsSpinnner = findViewById(R.id.espicalists);
        areas = findViewById(R.id.areaSpinner);


        String[] espicalists = getResources().getStringArray(R.array.espicalists);
        String[] countries = getResources().getStringArray(R.array.array_countries);


        final ArrayAdapter<String> adapterEspicalists = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, espicalists) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    //Disable the third item of spinner.
                    return false;
                } else {
                    return true;
                }
            }
        };
        final ArrayAdapter<String> adapterArear = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    //Disable the third item of spinner.
                    return false;
                } else {
                    return true;
                }
            }
        };

        espicalistsSpinnner.setAdapter(adapterEspicalists);
        areas.setAdapter(adapterArear);

        espicalistsSpinnner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemEspical = parent.getItemAtPosition(position).toString();

                Toast.makeText(SearchActivity.this, "" + adapterEspicalists.getItem(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        areas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemArea = parent.getItemAtPosition(position).toString();
                Toast.makeText(SearchActivity.this, "" + adapterEspicalists.getItem(position).toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void goToDoctorList(View view) {
        if (itemArea.isEmpty()||itemArea.equalsIgnoreCase("")){
            Toast.makeText(SearchActivity.this, "" + "Please Select Area", Toast.LENGTH_LONG).show();
        }else if (itemEspical.isEmpty()||itemEspical.equalsIgnoreCase("")){
            Toast.makeText(SearchActivity.this, "" + "Please Select Espical", Toast.LENGTH_LONG).show();
        }else {







            Intent intent = new Intent(SearchActivity.this, DoctorListActivity.class);
            startActivity(intent);
        }

    }


}

package com.example.mahmoudosman.medicalapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mahmoudosman.medicalapp.R;

public class AppointmentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_details);
    }



    public void submit(View view){

        Intent  intent= new Intent(AppointmentDetailsActivity.this,SearchActivity.class);
        Toast.makeText(AppointmentDetailsActivity.this,"Booking Done",Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}

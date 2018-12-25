package com.example.mahmoudosman.medicalapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mahmoudosman.medicalapp.R;
import com.example.mahmoudosman.medicalapp.model.DoctorModel;

public class DoctorDetails extends AppCompatActivity {

    DoctorModel currentDoctor;
    Button bookDoctor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        currentDoctor = getIntent().getParcelableExtra(Intent.EXTRA_TEXT);
        Log.e("doctor","doctor");


        bookDoctor=findViewById(R.id.btn_book);

    }



    public void messageDoctor(View view){
        Toast.makeText(DoctorDetails.this,"Hi Happy test",Toast.LENGTH_LONG).show();
    }
    public void bookDoctor(View view){

        Intent intent= new Intent(DoctorDetails.this,AppointmentDetailsActivity.class);
        startActivity(intent);


    }
}

package com.example.mahmoudosman.medicalapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mahmoudosman.medicalapp.R;
import com.example.mahmoudosman.medicalapp.adapter.DoctorAdapter;
import com.example.mahmoudosman.medicalapp.model.DoctorModel;

import java.util.ArrayList;

public class DoctorListActivity extends AppCompatActivity {

    RecyclerView rvDoctorList;
    DoctorAdapter doctorAdapter;
    ArrayList<DoctorModel> doctorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        rvDoctorList=findViewById(R.id.rv_doctor_list);


        DoctorModel doctorModel1= new DoctorModel("name1",R.drawable.testing,"description1","Heat1",1);
        DoctorModel doctorModel2= new DoctorModel("name2",R.drawable.testing,"description2","Heat2",2);
        DoctorModel doctorModel3= new DoctorModel("name3",R.drawable.testing,"description3","Heat3",3);
        DoctorModel doctorModel4= new DoctorModel("name4",R.drawable.testing,"description4","Heat4",4);
        DoctorModel doctorModel5= new DoctorModel("name5",R.drawable.testing,"description5","Heat5",5);
        DoctorModel doctorModel6= new DoctorModel("name6",R.drawable.testing,"description6","Heat6",4);
        doctorList= new ArrayList<>();
        doctorList.add(doctorModel1);
        doctorList.add(doctorModel2);
        doctorList.add(doctorModel3);
        doctorList.add(doctorModel4);
        doctorList.add(doctorModel5);
        doctorList.add(doctorModel6);

        doctorAdapter= new DoctorAdapter(doctorList,this);
        rvDoctorList.setLayoutManager(new LinearLayoutManager(this));
        rvDoctorList.setAdapter(doctorAdapter);

    }
}

package com.example.mahmoudosman.medicalapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DoctorModel implements Parcelable {

    private String doctorName;
    private int doctorPhoto;
    private String doctorDesc;
    private String doctorEspical;
    private float doctorRating;

    public DoctorModel(String doctorName, int doctorPhoto, String doctorDesc,String doctorEspical, float doctorRating) {
        this.doctorName = doctorName;
        this.doctorPhoto = doctorPhoto;
        this.doctorDesc = doctorDesc;
        this.doctorRating = doctorRating;
        this.doctorEspical=doctorEspical;
    }

    protected DoctorModel(Parcel in) {
        doctorName = in.readString();
        doctorPhoto = in.readInt();
        doctorDesc = in.readString();
        doctorRating = in.readFloat();
    }

    public String getDoctorEspical() {
        return doctorEspical;
    }


    public void setDoctorEspical(String doctorEspical) {
        this.doctorEspical = doctorEspical;
    }

    public static final Creator<DoctorModel> CREATOR = new Creator<DoctorModel>() {
        @Override
        public DoctorModel createFromParcel(Parcel in) {
            return new DoctorModel(in);
        }

        @Override
        public DoctorModel[] newArray(int size) {
            return new DoctorModel[size];
        }
    };

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(int doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getDoctorDesc() {
        return doctorDesc;
    }

    public void setDoctorDesc(String doctorDesc) {
        this.doctorDesc = doctorDesc;
    }

    public float getDoctorRating() {
        return doctorRating;
    }

    public void setDoctorRating(float doctorRating) {
        this.doctorRating = doctorRating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(doctorName);
        dest.writeInt(doctorPhoto);
        dest.writeString(doctorDesc);
        dest.writeFloat(doctorRating);
    }
}

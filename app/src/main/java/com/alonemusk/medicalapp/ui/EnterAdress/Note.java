package com.alonemusk.medicalapp.ui.EnterAdress;


import com.google.gson.annotations.SerializedName;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @SerializedName("address_id")
    @PrimaryKey(autoGenerate = true)
    private int address_id;

    @SerializedName("user_id")

    private int user_id;
    private String address;

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    private String landmark;
    private String city;
    private String state;
    private String mobile_no;

    @Override
    public String toString() {
        return "Note{" +
                "address_id=" + address_id +
                ", user_id=" + user_id +
                ", address='" + address + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", mobile_no='" + mobile_no + '\'' +
                '}';
    }

    public Note(int user_id,
                String address,
                String landmark,
                String city,
                String state, String mobile_no) {
        this.user_id = user_id;
        this.address = address;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.mobile_no = mobile_no;
    }

    public int getAddress_id() {
        return address_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAddress() {
        return address;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getMobile_no() {
        return mobile_no;
    }


}


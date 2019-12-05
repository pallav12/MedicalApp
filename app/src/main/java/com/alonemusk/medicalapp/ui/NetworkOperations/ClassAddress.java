package com.alonemusk.medicalapp.ui.NetworkOperations;

import com.google.gson.annotations.SerializedName;

public class ClassAddress {


    @SerializedName("address_id")
    private int address_id;


    @SerializedName("user_id")
    private int user_id;


    @SerializedName("address")
    private String address;


    @SerializedName("landmark")
    private String landmark;

    @SerializedName("city")
    private String city;


    @SerializedName("state")
    private String state;

    @SerializedName("mobile_no")
    private String mobile_no;


    public ClassAddress(int user_id,int address_id,
                        String address,
                        String landmark,
                        String city,
                        String state, String mobile_no) {
        this.address_id = address_id;
        this.user_id=user_id;
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

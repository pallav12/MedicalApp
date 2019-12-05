package com.alonemusk.medicalapp.ui.NetworkOperations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolder {
    @GET("10001")
    Call<List<ClassAddress>> getPosts();
    @POST("insert-address")
    Call<ClassAddress>post(@Body ClassAddress classAddress);
}

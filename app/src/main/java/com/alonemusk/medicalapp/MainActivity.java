package com.alonemusk.medicalapp;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alonemusk.medicalapp.ui.NetworkOperations.ClassAddress;
import com.alonemusk.medicalapp.ui.NetworkOperations.JsonPlaceHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.something);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-16-216-35.us-east-2.compute.amazonaws.com:3000/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolder jsonPlaceHolder = retrofit.create(JsonPlaceHolder.class);

        ClassAddress post = new ClassAddress(23,
                23, "New Text", "Hello",
                "SOmething", "Doesnt matter", "Not a string");


        Call<ClassAddress> call = jsonPlaceHolder.post(post);

        call.enqueue(new Callback<ClassAddress>() {
            @Override
            public void onResponse(Call<ClassAddress> call, Response<ClassAddress> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.toString());

                }
                else{
                    Toast.makeText(getApplicationContext(),"hello hello hello",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<ClassAddress> call, Throwable t) {
                textViewResult.setText(t.getMessage() +"Je llo lejlo elsfj");
            }
        });

        Intent intent=new Intent(getApplicationContext(),FirstActivity.class);
        startActivity(intent);
    }
}

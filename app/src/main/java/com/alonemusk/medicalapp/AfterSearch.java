package com.alonemusk.medicalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AfterSearch extends AppCompatActivity {
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_search);
        textView=findViewById(R.id.tv);
        Intent intent=getIntent();
        textView.setText(intent.getStringExtra("medicine"));

    }
}

package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        change this to change startup file
        setContentView(R.layout.activity_main);
    }


    public void Intend(View view)
    {
        Intent intent = new Intent (MainActivity.this,NewIntend.class);
        startActivity(intent);
    }


}
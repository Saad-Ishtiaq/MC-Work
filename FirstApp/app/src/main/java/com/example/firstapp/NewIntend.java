package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NewIntend extends AppCompatActivity {

    static int count=0;
    TextView tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_intend);
        tView=findViewById(R.id.textView);
        tView.setText( String.valueOf (count));
    }

    public void CLicked(View view)
    {
        count++;
        tView.setText( String.valueOf (count)  );
    }

    public void NewIntend(View view)
    {
        Intent intent = new Intent (NewIntend.this,counter.class);
        startActivity(intent);
    }





}
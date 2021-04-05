package com.example.firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class counter extends AppCompatActivity {

    TextView textView;
    Button button;
    int count=0;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ALC","onStartCalled");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ALC","onPauseCalled");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ALC","onResumeCalled");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ALC","onStopCalled");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ALC","onDestroyCalled");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("value",count);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        button = findViewById(R.id.countButton);
        textView = findViewById(R.id.counterShow);

        Log.d("ALC","onCreateCalled");
        if(savedInstanceState!=null)
        {
            count=savedInstanceState.getInt("value");
            textView.setText(String.valueOf(count));
        }
    }
    public void IncreaseNumber(View view) {
        count=Integer.parseInt(textView.getText().toString());
        count++;
        textView.setText(String.valueOf(count));
    }
}



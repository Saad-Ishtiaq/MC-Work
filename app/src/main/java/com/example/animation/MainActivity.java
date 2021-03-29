package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Animation(View view) {

//        imageView.animate().alpha(0).setDuration(2000);
//        imageView.animate().translationYBy(-2000).setDuration(2000);
        ImageView imageView=findViewById(R.id.imageView);
        imageView.animate().rotation(180).setDuration(10000).translationYBy(-800).setDuration(8000);

        ImageView imageView2=findViewById(R.id.imageView2);
        imageView2.animate().rotation(720).setDuration(10000).translationYBy(-800).setDuration(8000);

    }

    public void Animation2(View view) {
        ImageView imageView=findViewById(R.id.imageView);
        imageView.animate().rotation(180).setDuration(10000).translationYBy(-800).setDuration(8000);


        ImageView imageView2=findViewById(R.id.imageView2);
        imageView2.animate().rotation(720).setDuration(10000).translationYBy(-800).setDuration(8000);
    }
}
package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textBox;
    TextView nameBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        button = findViewById(R.id.button);
        textBox= findViewById(R.id.textView2);
        nameBox= findViewById(R.id.name);
    }

    public void TextAdded(View view) {
        textBox.append("->  ");
        textBox.append( nameBox.getText());
        nameBox.setText("");
        textBox.append("\n");
    }


    public void Call(View view)
    {
        Uri uri = Uri.parse("tel:+923334200675");
        Intent intent = new Intent (Intent.ACTION_DIAL, uri);
        startActivity(intent);

    }


    public void ShowWebsite(View view)
    {
        Uri uri = Uri.parse("https://www.pucit.edu.pk");
        Intent intent = new Intent (Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void NewActivity(View view)
    {
        Intent intent = new Intent (MainActivity.this,OurActivity.class);
        startActivity(intent);
    }






}
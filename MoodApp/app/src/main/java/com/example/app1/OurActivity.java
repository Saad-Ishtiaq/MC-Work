package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class OurActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our);



        ListView listView= findViewById(R.id.myListView);

        final ArrayList<String> friends= new ArrayList<String>();
        friends.add("AbuBakr");
        friends.add("Umar");
        friends.add("Usman");
        friends.add("Ali");


        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, friends);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("You CLicked:", friends.get(position));



            }
        });




//        Insert Button

        EditText editText =findViewById(R.id.inputBox);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInsert=editText.getText().toString();
                friends.add((nameInsert));

                arrayAdapter.notifyDataSetChanged();

                Collections.sort(friends);
            }
        });

    }
}
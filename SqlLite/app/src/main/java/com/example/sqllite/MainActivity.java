package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addButton, viewButton;
    EditText editName, editAge;
    Switch isActive;
    ListView listViewPersonDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton=findViewById(R.id.addButton);
        viewButton=findViewById(R.id.viewRecord);
        editName=findViewById(R.id.editPersonName);
        editAge= findViewById(R.id.editPersonAge);
        isActive= findViewById(R.id.switch1);


        addButton.setOnClickListener( new View.OnClickListener() {
            Customer customerModal;

            @Override
            public void onClick(View v) {
                ////Shows Message
                //Toast.makeText(MainActivity.this, "Add Record Clicked", Toast.LENGTH_SHORT).show();


                customerModal = new  Customer(editName.getText().toString(),Integer.parseInt(editAge.getText().toString()),isActive.isChecked(),1);
                Toast.makeText(MainActivity.this, customerModal.toString(), Toast.LENGTH_LONG).show();

            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "View Record Clicked", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
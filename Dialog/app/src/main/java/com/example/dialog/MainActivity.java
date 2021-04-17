package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.button);
    }
    public void showDialog(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("It is message of my Dialog");
        builder.setTitle("Dialog Title");
        builder.setCancelable(false);

        LayoutInflater inflater= this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.my_layout_dialog,null));
        builder.setPositiveButton("Positive",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Positive Button was clicked.",Toast.LENGTH_LONG).show();
                    }
                }
        );

        builder.setNegativeButton("Negative",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"Negative Button was clicked.",Toast.LENGTH_LONG).show();
                    }
                }
        );
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }













    public void colors(View view) {

        String [] Colors = {"Red", "Green", "Blue","Yellow"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SetColor")
                .setItems(Colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, Colors[which], Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }











    public void selectColors(View view) {
        String [] Colors = {"Red", "Green", "Blue"};
        ArrayList<Integer> selectedItems = new ArrayList();  // Where we track the selected items

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select options")
                .setMultiChoiceItems(Colors, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            selectedItems.add(which);
                        } else if (selectedItems.contains(which)) {
                            selectedItems.remove(Integer.valueOf(which));
                        }
                    }
                }
        );

        builder.setCancelable(false);

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "";
                for (int i = 0; i < selectedItems.size(); i++) {
                    msg = msg + "\n" + (i + 1) + " : " + Colors[ selectedItems.get(i)];
                }
                Toast.makeText(getApplicationContext(), "Total " + selectedItems.size() + " Items Selected.\n"
                        + msg, Toast.LENGTH_SHORT).show();
            }
            }
        );

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"No Option Selected",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        AlertDialog dialog  = builder.create();
        dialog.show();
    }
}
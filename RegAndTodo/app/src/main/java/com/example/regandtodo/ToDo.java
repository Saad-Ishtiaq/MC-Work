package com.example.regandtodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ToDo extends AppCompatActivity {

    Button button;
    TextView textView;
    TextView inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        button=findViewById(R.id.button2);
        inputText=findViewById(R.id.inputBox);
        textView=findViewById(R.id.showText);

    }

    public void ToDoList(View view)
    {
        textView.append("->  ");
        textView.append( inputText.getText());
        inputText.setText("");
        textView.append("\n");
    }


    public void Clear(View view)
    {
        textView.setText("");
        inputText.setText("");
    }

    public void Google(View view)
    {
        Uri uri = Uri.parse("https://www.google.com");
        Intent intent = new Intent (Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void Call(View view)
    {
        Uri uri = Uri.parse("tel:+923354181927");
        Intent intent = new Intent (Intent.ACTION_DIAL, uri);
        startActivity(intent);

    }

    public void Github(View view)
    {
        Uri uri = Uri.parse("https://github.com/Saad-Ishtiaq");
        Intent intent = new Intent (Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }




}
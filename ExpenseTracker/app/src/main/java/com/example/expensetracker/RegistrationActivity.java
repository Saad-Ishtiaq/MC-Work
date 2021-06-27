package com.example.expensetracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email,password;
    private Button registerBtn;
    private TextView registerQn;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth= FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        registerBtn=findViewById(R.id.registerBtn);
        registerQn=findViewById(R.id.registerQn);

        registerQn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString= email.getText().toString();
                String passwordString= password.getText().toString();

                if(TextUtils.isEmpty(emailString)){
                    email.setError("Email is required!");
                }
                if(TextUtils.isEmpty(passwordString)){
                    password.setError("Password is required!");
                }
                else if(!emailString.matches(emailPattern)){
                    progressDialog.dismiss();
                    email.setError("Invalid Email");
                }else  if(password.length()<6){
                    progressDialog.dismiss();
                    password.setError("Invalid Password- write at-least 6 characters");
                }
                else {

                    progressDialog.setMessage("Sign Up Progress");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.createUserWithEmailAndPassword(emailString,passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intent= new Intent(RegistrationActivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                                progressDialog.dismiss();
                            }else {
                                Toast.makeText(RegistrationActivity.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });


                }
            }
        });

    }
}
package com.example.meroarkoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText FullName,Email,Password,RePassword,Address,DOB,Username;
    private AppCompatButton signup_btn,login_btn;
    private CheckBox checkPlaying,checkDancing,checkSinging,checkCoding,checkTermsAndCondition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initToolbar();
        findViews();
    }


    private void findViews(){
        FullName = findViewById(R.id.fullname);
        Email = findViewById(R.id.email);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        RePassword = findViewById(R.id.reenterpassword);
        Address = findViewById(R.id.address);
        DOB = findViewById(R.id.dob);
        signup_btn = findViewById(R.id.signup_btn);


//        checkPlaying = findViewById(R.id.check_playing);
//        checkDancing = findViewById(R.id.check_dancing);
//        checkCoding = findViewById(R.id.check_coding);
//        checkSinging  = findViewById(R.id.check_singing);
        checkTermsAndCondition = findViewById(R.id.check_TermsAndCondition);



        // below function gives the activity in signup btn click
        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(error())
                {
                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }




    private boolean error(){
        if(FullName.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your name.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(Email.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your Email.", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(Username.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your desired Username.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(Password.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this, "Please set Password.", Toast.LENGTH_LONG).show();
            return false;
        }
        else if(Password.getText().toString().length()<8){
            Toast.makeText(SignUpActivity.this, "Password must have 8 characters.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(RePassword.getText().toString().isEmpty()){
            Toast.makeText(SignUpActivity.this, "Enter your password again.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(!RePassword.getText().toString().equals(Password.getText().toString()))
        {
            Toast.makeText(SignUpActivity.this, "Password does not match.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(DOB.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your Date of Birth.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(Address.getText().toString().isEmpty())
        {
            Toast.makeText(SignUpActivity.this, "Please Provide your Address.", Toast.LENGTH_LONG).show();
            return false;
        }

        else if(!checkTermsAndCondition.isChecked())
        {
            Toast.makeText(SignUpActivity.this, "Please Agree Terms and Conditions.", Toast.LENGTH_LONG).show();
            return false;
        }

//
//        else if(checkPlaying.isChecked() || checkDancing.isChecked() || checkCoding.isChecked() || checkSinging.isChecked())
//        {
//
//        }
        else
        {
            Toast.makeText(SignUpActivity.this, "New User Registered Successfully.", Toast.LENGTH_LONG).show();

        }


        return true;
    }


    private void initToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sign Up Page");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }



}
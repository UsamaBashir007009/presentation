package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Viewmodel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        vm= Viewmodel.getInstance();
    }

    public void createProfile(View v)   {
        EditText ed1 = findViewById(R.id.etUsername);
        if(ed1.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"User name cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }
        EditText ed2 = findViewById(R.id.etPass);
        if(ed2.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"password cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }
        if(ed2.getText().toString().length()<8) {

            Toast.makeText(getApplicationContext(),"password must have atleast 8 characters",Toast.LENGTH_LONG).show();
            return;
        }
        EditText ed3 = findViewById(R.id.etRePass);
        if(ed3.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Retype password",Toast.LENGTH_LONG).show();
            return;
        }
        if(!(ed2.getText().toString().equals(ed3.getText().toString()))){

            Toast.makeText(getApplicationContext(),"Passwords are not matching",Toast.LENGTH_LONG).show();
            return;
        }
        EditText ed4 = findViewById(R.id.etName);
        if(ed4.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"Name cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }
        int result=vm.createaccount(ed4.getText().toString(),ed1.getText().toString(),ed2.getText().toString());
        if(result== -1)
        {
            Toast.makeText(getApplicationContext(),"User name not Available",Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Account Created",Toast.LENGTH_LONG).show();
            Intent i =new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }
    }

}

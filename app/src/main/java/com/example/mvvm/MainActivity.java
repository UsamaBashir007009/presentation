package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Viewmodel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm=Viewmodel.getInstance();
        if(vm.current!=null) {
            EditText ed1 = findViewById(R.id.etUname2);
            EditText ed2 = findViewById(R.id.passsword2);
            ed1.setText(vm.current.username);
            ed2.setText(vm.current.passsword);
        }
    }
    public void onRestart()
    {
        super.onRestart();
        if(vm.current!=null) {
            EditText ed1 = findViewById(R.id.etUname2);
            EditText ed2 = findViewById(R.id.passsword2);
            ed1.setText(vm.current.username);
            ed2.setText(vm.current.passsword);
        }
    }
    public void Login(View v){
        EditText ed1 = findViewById(R.id.etUname2);
        if(ed1.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"User name cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }
        EditText ed2 = findViewById(R.id.passsword2);
        if(ed2.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),"password cannot be empty",Toast.LENGTH_LONG).show();
            return;
        }

        int result= vm.login(ed1.getText().toString(),ed2.getText().toString());
        if(result==1)
        {
            String s= "Welcome! " +vm.current.name;
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            Intent i=new Intent(this,Welcome.class);
            startActivity(i);

        }
        else if(result==2)
        {
            Toast.makeText(getApplicationContext(),"Passworg is Wrong",Toast.LENGTH_LONG).show();
        }
        else if(result==3)
        {
            Toast.makeText(getApplicationContext(),"User name is Wrong",Toast.LENGTH_LONG).show();
        }
        else
        {
            String s= "No user with this name! ";
            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
        }

    }
    public void signUp(View v)
    {
        Intent i =new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}

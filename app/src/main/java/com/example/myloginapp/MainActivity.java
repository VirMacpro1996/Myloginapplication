package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    boolean temp = false;
    boolean dtemp = false;
    String status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView email =  (TextView) findViewById(R.id.email);
        TextView security =  (TextView) findViewById(R.id.security);
        TextView password =  (TextView) findViewById(R.id.password);
        Button register = (Button)  findViewById(R.id.register);
        Button clear = (Button)  findViewById(R.id.clear);
        Button display = (Button)  findViewById(R.id.display);
        Button overwrite = (Button)  findViewById(R.id.overwrite);

        String email_txt =  email.getText().toString();
        String pwd_txt =  password.getText().toString();
        String security_txt =  security.getText().toString();
        DatabaseHandler db = new DatabaseHandler(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_txt =  email.getText().toString();
                String pwd_txt =  password.getText().toString();
                String security_txt =  security.getText().toString();
                db.addUser(new User(email_txt, pwd_txt, security_txt));
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(MainActivity.this, "email : ", Toast.LENGTH_LONG).show();

                Log.d("Reading: ", "Reading all Users ..... ");
                List<User> users = db.getAllContacts();

                for (User cn : users) {
                    String log = "Username : " + cn.getUsername() + " , Password : " + cn.getPassword() + " , Security: " +
                            cn.getSecurity();
                    // Writing Contacts to log
                    Log.d("Name: ", log);

                }
            }
        });







        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switchbtn= (Switch) findViewById(R.id.simpleswitch);

        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {

                if (isChecked) {

                    //value="YES";
                    switchbtn.setTextColor(Color.GREEN);
                    Toast.makeText(MainActivity.this, "SQLIte Database : ", Toast.LENGTH_LONG).show();


                } else {

                    Toast.makeText(MainActivity.this, "Shared Preferences  : ", Toast.LENGTH_LONG).show();

                }

            }
            });



        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email.setText(" ");
                password.setText(" ");
                security.setText(" ");
            }
        });


        overwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        }
    }





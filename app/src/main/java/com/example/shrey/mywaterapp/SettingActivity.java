package com.example.shrey.mywaterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Set;

public class SettingActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        database =FirebaseDatabase.getInstance();
        Intent intent =getIntent();
        user_id= intent.getStringExtra("user_id");

    }

    public void change_name(View view)
    {
        EditText setting_name= findViewById(R.id.setting_name);
        String name =setting_name.getText().toString().trim();

        if(TextUtils.isEmpty(name))
            Toast.makeText(SettingActivity.this,"Enter Name",Toast.LENGTH_SHORT).show();

        else
        {
            myRef=database.getReference("Users").child(user_id);
            myRef.child("Name").setValue(name);
            Toast.makeText(SettingActivity.this,"Name Updated",Toast.LENGTH_SHORT).show();
        }
        setting_name.setText("");
    }

    public void change_email(View view)
    {
        EditText setting_email= findViewById(R.id.setting_email);
        String email =setting_email.getText().toString().trim();

        if(TextUtils.isEmpty(email))
            Toast.makeText(SettingActivity.this,"Enter email",Toast.LENGTH_SHORT).show();

        else
        {
            myRef=database.getReference("Users").child(user_id);
            myRef.child("Email").setValue(email);
            Toast.makeText(SettingActivity.this,"Email Updated",Toast.LENGTH_SHORT).show();
        }
        setting_email.setText("");
    }

    public void change_mobile(View view)
    {
        EditText setting_mobile= findViewById(R.id.setting_mobile);
        String mobile =setting_mobile.getText().toString().trim();

        if(TextUtils.isEmpty(mobile))
            Toast.makeText(SettingActivity.this,"Enter Mobile No",Toast.LENGTH_SHORT).show();

        else
        {
            myRef=database.getReference("Users").child(user_id);
            myRef.child("Mobile").setValue(mobile);
            Toast.makeText(SettingActivity.this,"Mobile No Updated",Toast.LENGTH_SHORT).show();
        }
        setting_mobile.setText("");
    }
}

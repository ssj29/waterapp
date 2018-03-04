package com.example.shrey.mywaterapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    String user_id;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        TextView user_home = findViewById(R.id.home_user);
        Intent intent = getIntent();
        String info = intent.getStringExtra("user_info");
        user_id = intent.getStringExtra("user_id");
        user_home.setText(info);
    }

    public  void pay(View view)
    {

    }

    public void tips(View view)
    {
        Intent intent = new Intent(MenuActivity.this,TipsActivity.class);
        startActivity(intent);
    }

    public void complaint(View view)
    {
            Intent intent = new Intent(MenuActivity.this,ComplaintActivity.class);

            intent.putExtra("user_id",user_id);

            startActivity(intent);
    }

    public void history(View view)
    {

    }

    public void setting(View view)
    {
    Intent intent = new Intent(MenuActivity.this,SettingActivity.class);
    intent.putExtra("user_id",user_id);
    startActivity(intent);
    }

    public void logout_button(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        Intent intent = new Intent(MenuActivity.this,LoginActivity.class);
        startActivity(intent);
    }
}

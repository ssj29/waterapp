package com.example.shrey.mywaterapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class LoginActivity extends AppCompatActivity {

    String user,pass,msg,msg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void login_button(View view)
    {
        EditText user_id = findViewById(R.id.user_name);
        EditText password= findViewById(R.id.user_password);
        user = user_id.getText().toString().trim();
        pass = password.getText().toString().trim();
        msg=user_id.getText().toString().trim();
        msg2=password.getText().toString().trim();
        if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass))
        {
            Toast.makeText(this,"Please Enter both fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            FirebaseAuth mAuth;
            mAuth =FirebaseAuth.getInstance();
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful())
                         {
                             Toast.makeText(LoginActivity.this,"your login",Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                             intent.putExtra("user_info",msg);
                             intent.putExtra("user_id",msg2);
                             startActivity(intent);
                         }
                         else
                         {
                             Toast.makeText(LoginActivity.this,"Wrong credentials",Toast.LENGTH_SHORT).show();
                         }
                }
            });
        }

    }

   public void signup_button(View view)
    {
        Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
        startActivity(intent);

    }
}

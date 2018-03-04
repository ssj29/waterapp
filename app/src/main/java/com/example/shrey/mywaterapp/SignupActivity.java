package com.example.shrey.mywaterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignupActivity extends AppCompatActivity {

    String user,pass,mobile,email,child;
    public FirebaseAuth mAuth;
    public FirebaseDatabase database;
    public DatabaseReference myRef;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signup);

    mAuth = FirebaseAuth.getInstance();
    database=FirebaseDatabase.getInstance();
    }


    public void button_sign(View view)
    {

      final EditText full_name= findViewById(R.id.Sign_Name);
      final EditText password= findViewById(R.id.Sign_Pass);
      final EditText mobile_no= findViewById(R.id.Sign_Mobile);
      final EditText email_id= findViewById(R.id.Sign_Email);

      user =full_name.getText().toString().trim();
      pass = password.getText().toString().trim();
      mobile = mobile_no.getText().toString().trim();
      email = email_id.getText().toString().trim();
      child = password.getText().toString().trim();


      if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(pass) && !TextUtils.isEmpty(mobile) && !TextUtils.isEmpty(email)) {
          mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
              @Override
              public void onComplete(@NonNull Task<AuthResult> task) {

                  if (task.isSuccessful()) {

                      Toast.makeText(SignupActivity.this, "User is created...!!", Toast.LENGTH_SHORT).show();
                  }
              }
          });
      }
      else
          Toast.makeText(SignupActivity.this,"Please fill the all field",Toast.LENGTH_SHORT).show();

        myRef = database.getReference("Users").child(child);
        myRef.child("Name").setValue(full_name.getText().toString());
        myRef.child("pass").setValue(password.getText().toString());
        myRef.child("Email").setValue(email_id.getText().toString());
        myRef.child("Mobile").setValue(mobile_no.getText().toString());

        full_name.setText("");
        password.setText("");
        mobile_no.setText("");
        email_id.setText("");


  }
    public void login_button(View view)
    {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}

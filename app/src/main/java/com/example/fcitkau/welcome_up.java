 package com.example.fcitkau;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

 public class welcome_up extends AppCompatActivity {


     public Button Button1;
     public FirebaseAuth mAuth;
     public EditText sname,semail,spassword,spassword2;
     public Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_up);

        sname = findViewById(R.id.emile_in);
        semail = findViewById(R.id.up_email);
        spassword = findViewById(R.id.password);
        signup = findViewById(R.id.up_go);
        spassword2 = findViewById(R.id.password2);



        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emile = semail.getText().toString().trim();
                String password = spassword.getText().toString().trim();
                String password2 = spassword2.getText().toString().trim();

                if(TextUtils.isEmpty(emile)){
                    Toast.makeText(welcome_up.this, "Emile is empty", Toast.LENGTH_SHORT).show();
                    semail.setError("Emile is empty");
                    return;
                }

                if (!password.equals(password2)){
                    Toast.makeText(welcome_up.this, "password is not a match", Toast.LENGTH_SHORT).show();
                    spassword.setError("password is not a match");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(welcome_up.this, "password is required", Toast.LENGTH_SHORT).show();
                    spassword.setError("password is required");
                    return;
                }


                if (password.length()< 8){
                    Toast.makeText(welcome_up.this, "password must be grater than 8 characters", Toast.LENGTH_SHORT).show();
                    spassword.setError("password must be grater than 8 characters");
                    return;
                }

                //firbase

                mAuth.createUserWithEmailAndPassword(emile,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(welcome_up.this, "User Created successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(welcome_up.this, "Error !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });


        Button1 = (Button) findViewById(R.id.button10);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

     public void login(){

         Intent intent = new Intent(this,welocome_log.class);
         startActivity(intent);
     }
}

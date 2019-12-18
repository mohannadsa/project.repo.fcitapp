package com.example.fcitkau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class welocome_log extends AppCompatActivity {

    public Button Button;
    public EditText semail,spassword;
    public FirebaseAuth mAuth;
    public Button slogin;
    TextView passf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welocome_log);

        semail = findViewById(R.id.emile_in);
        spassword = findViewById(R.id.password);
        slogin = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();

        passf  = (TextView) findViewById(R.id.forgotpass);
        passf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), fogotpassword.class));
            }
        });

        slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emile = semail.getText().toString().trim();
                String password = spassword.getText().toString().trim();

                if(TextUtils.isEmpty(emile)){
                    semail.setError("Emile is empty");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    spassword.setError("password is required");
                    return;
                }

                if (password.length()< 8){
                    spassword.setError("password must be grater than 8 characters");
                    return;
                }

                //auth

                mAuth.signInWithEmailAndPassword(emile,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(welocome_log.this, "welcome to Fcit app", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else{
                            Toast.makeText(welocome_log.this, "Error ! Emile or password is not correct", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });




        Button = (Button) findViewById(R.id.button11);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signuo();
            }
        });

    }

    public void signuo(){

        Intent intent = new Intent(this,welcome_up.class);
        startActivity(intent);
    }


}

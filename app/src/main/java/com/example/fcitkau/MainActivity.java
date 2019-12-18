package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public Button Button;
    public Button Button2;
    public Button Button3;
    public Button Button4;
    public Button Button5;
    public Button Button6;
    public Button Button7;
    public Button Button8;
    Dialog sidemin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sidemin = new Dialog(this);

        Button = (Button) findViewById(R.id.black);
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfcitmap();
            }
        });

        Button2 = (Button) findViewById(R.id.kau);
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenL();
            }
        });

        Button3 = (Button) findViewById(R.id.oudes);
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lostandfound();
            }
        });

        Button4 = (Button) findViewById(R.id.youtube);
        Button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                News();
            }
        });

        Button5 = (Button) findViewById(R.id.kautwt);
        Button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Feedback();
            }
        });

        Button6 = (Button) findViewById(R.id.button9);
        Button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydownload();
            }
        });

        Button7 = (Button) findViewById(R.id.button11);
        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });

        Button8 = (Button) findViewById(R.id.button6);
        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myprofile();
            }
        });


    }

    public void sidpop(View view){
        TextView xclose;
        Button logout;
        Button rate;
        Button about;
        Button links;

        sidemin.setContentView(R.layout.sidmin);

        xclose = (TextView) sidemin.findViewById(R.id.close);
        logout = (Button) sidemin.findViewById(R.id.logout);
        rate = (Button) sidemin.findViewById(R.id.Rate);
        about = (Button) sidemin.findViewById(R.id.Aboutus);
        links = (Button) sidemin.findViewById(R.id.Links);

        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), rate_app.class));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), about_us.class));
            }
        });

        links.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), importent_links.class));
            }
        });


        xclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sidemin.dismiss();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
        sidemin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sidemin.show();
    }

    public void logout(){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), welocome_log.class));
        finish();
    }

    public void myprofile(){

        Intent intent = new Intent(this, myprofile.class);
        startActivity(intent);
    }

    public void home(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void mydownload(){

        Intent intent = new Intent(this, my_download.class);
        startActivity(intent);
    }

    public void openfcitmap(){

        Intent intent = new Intent(this, FCITMAP.class);
        startActivity(intent);
    }

    public void OpenL(){
        Intent intent = new Intent(this,Openl.class);
        startActivity(intent);

    }

    public void lostandfound(){
        Intent intent = new Intent(this,lostandfound.class);
        startActivity(intent);

    }

    public void News(){
        Intent intent = new Intent(this,News.class);
        startActivity(intent);

    }

    public void Feedback(){
        Intent intent = new Intent(this,Feedback.class);
        startActivity(intent);

    }


}

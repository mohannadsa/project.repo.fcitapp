package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class News extends AppCompatActivity {

    public Button Button6;
    public Button Button7;
    public Button Button8;


    Dialog cnews1pop;
    Dialog cnews2pop;
    Dialog sidemin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        cnews1pop = new Dialog(this);
        cnews2pop = new Dialog(this);
        sidemin = new Dialog(this);

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
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), welocome_log.class));
                finish();
            }
        });
        sidemin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        sidemin.show();
    }


    public void popnews1(View view){

        Button Reg;

        cnews1pop.setContentView(R.layout.news1pop);

        Reg = (Button) cnews1pop.findViewById(R.id.register);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(News.this, "you have registered to LINUx Curse", Toast.LENGTH_SHORT).show();
                cnews1pop.dismiss();
            }
        });
        //cnews1pop.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        cnews1pop.show();
    }

    public void popnews2(View view){

        Button Reg;

        cnews2pop.setContentView(R.layout.nwes2pop);

        Reg = (Button) cnews2pop.findViewById(R.id.register);

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(News.this, "you have registered to excel Curse", Toast.LENGTH_SHORT).show();
                cnews2pop.dismiss();
            }
        });
        cnews2pop.show();
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
}

package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class importent_links extends AppCompatActivity {

    public Button black;
    public Button kau;
    public Button youtube;
    public Button oudes;
    public Button kautwt;
    public Button fcittwt;

    public Button Button6;
    public Button Button7;
    public Button Button8;
    Dialog sidemin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importent_links);
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


        black = (Button) findViewById(R.id.black);
        kau = (Button) findViewById(R.id.kau);
        youtube = (Button) findViewById(R.id.youtube);
        oudes = (Button) findViewById(R.id.oudes);
        kautwt = (Button) findViewById(R.id.kautwt);
        fcittwt = (Button) findViewById(R.id.fcittwt);


        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://iam.kau.edu.sa/oamsso-bin/login.pl?resource_url=https%3A%2F%2Fsso.kau.edu.sa%252F"));
                startActivity(BrowswerIntent);
            }
        });
        kau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kau.edu.sa/"));
                startActivity(BrowswerIntent);
            }
        });
        youtube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/kaufcit"));
                startActivity(BrowswerIntent);
            }
        });
        oudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://odusplus-ss.kau.edu.sa"));
                startActivity(BrowswerIntent);
            }
        });
        kautwt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/kauweb"));
                startActivity(BrowswerIntent);
            }
        });
        fcittwt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BrowswerIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/FCITKAU"));
                startActivity(BrowswerIntent);
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

package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class FCITMAP extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public Button Button6;
    public Button Button7;
    public Button Button8;
    ImageView floor1;
    ImageView floor2;
    ImageView floor3;
    ImageView floor1key;
    ImageView floor2key;
    ImageView floor3key;
    Dialog sidemin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcitmap);

        sidemin = new Dialog(this);

        Spinner Floors = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.Floors , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Floors.setAdapter(adapter);
        Floors.setOnItemSelectedListener(this);

        floor1 = (ImageView) findViewById(R.id.gfloormap);
        floor1key = (ImageView) findViewById(R.id.gfloorkey);

        floor2 = (ImageView) findViewById(R.id.firstfloormap);
        floor2key = (ImageView) findViewById(R.id.firstfloorkey);

        floor3 = (ImageView) findViewById(R.id.secendfloormap);
        floor3key = (ImageView) findViewById(R.id.secendfloorkey);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0){

            floor1.setVisibility(View.VISIBLE);
            floor1key.setVisibility(View.VISIBLE);

            floor2.setVisibility(View.INVISIBLE);
            floor2key.setVisibility(View.INVISIBLE);

            floor3.setVisibility(View.INVISIBLE);
            floor2key.setVisibility(View.INVISIBLE);

        }
        else if (position == 1){

            floor1.setVisibility(View.INVISIBLE);
            floor1key.setVisibility(View.INVISIBLE);


            floor2.setVisibility(View.VISIBLE);
            floor2key.setVisibility(View.VISIBLE);

            floor3.setVisibility(View.INVISIBLE);
            floor3key.setVisibility(View.INVISIBLE);
        }
        else if (position == 2){

            floor1.setVisibility(View.INVISIBLE);
            floor1key.setVisibility(View.INVISIBLE);

            floor2.setVisibility(View.INVISIBLE);
            floor2key.setVisibility(View.INVISIBLE);

            floor3.setVisibility(View.VISIBLE);
            floor3key.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

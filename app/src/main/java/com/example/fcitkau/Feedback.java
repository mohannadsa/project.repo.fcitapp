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
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;


public class Feedback extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public Button Button6;
    public Button Button7;
    public Button Button8;

    TextView title;
    TextView s1;
    TextView s2;
    TextView s3;
    TextView s4;
    Dialog sidemin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        sidemin = new Dialog(this);

        title = (TextView) findViewById(R.id.SubjectTiltle);
        s1 = (TextView) findViewById(R.id.student1);
        s2 = (TextView) findViewById(R.id.student2);
        s3 = (TextView) findViewById(R.id.Student3);
        s4 = (TextView) findViewById(R.id.Student4);


        Spinner sujects = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this, R.array.Subjcts , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sujects.setAdapter(adapter);
        sujects.setOnItemSelectedListener(this);

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (position == 0){
            title.setText("It issues and management");
            s1.setText("Student 1: dr.adeeb is really nice and strict doctor");
            s2.setText("Student 2: the Grope project need lots of work");
            s3.setText("Student 3: easy subject");
            s4.setText("    ");
        }if (position == 1){
            title.setText("Human Computer interaction");
            s1.setText("Student 1: It was very fun subject");
            s2.setText("Student 2: chalnging need stuying");
            s3.setText("Student 3: you have to take it with dr.faris he is relly good ");
            s4.setText("Student 4: Dr.faris is the best dr");
        }if (position == 2){
            title.setText("Programing 1");
            s1.setText("Student 1: good for biggners");
            s2.setText("Student 2: if its your first time study erlly");
            s3.setText("Student 3: do the assignment dont procrastinate");
            s4.setText("Student 4: dr.abdallh march is the best");

        }if (position == 3){
            title.setText("Computer organization and architecture");
            s1.setText("Student 1: dr.mohammad is relly strict");
            s2.setText("Student 2: the project is hardwer");
            s3.setText("Student 3: need lots of work in the projects");
            s4.setText("Student 4: dr.mohammad exams are hard");

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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

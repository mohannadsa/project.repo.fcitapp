package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread thread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(1500  );
                   Intent Intent = new Intent (getApplicationContext(), welocome_log.class);

                   startActivity(Intent);
                   finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    thread.start();




    }
}

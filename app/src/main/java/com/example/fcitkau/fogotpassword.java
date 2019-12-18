package com.example.fcitkau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class fogotpassword extends AppCompatActivity {

    Button submet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fogotpassword);

        submet = findViewById(R.id.button);
        submet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(fogotpassword.this, "A Massage have Been sent to your Email", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), welocome_log.class));
            }
        });
    }
}

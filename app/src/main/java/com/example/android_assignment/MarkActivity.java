package com.example.android_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MarkActivity extends AppCompatActivity {

    Button navHome, navMark, navWork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mark);

        navMark = findViewById(R.id.navMark);
        navHome = findViewById(R.id.navHome);
        navWork = findViewById(R.id.navWork);

        navHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MarkActivity.this, MainActivity.class));
            }
        });

        navWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MarkActivity.this, WorkActivity.class));
            }
        });

        navMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MarkActivity.this, MarkActivity.class));
            }
        });
    }
}

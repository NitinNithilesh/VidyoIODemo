package com.example.pfuternik.vidyoiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Schedule1 extends AppCompatActivity  {
    private Button today;
    private Button tomorrow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule1);
        today=(Button)findViewById(R.id.button1);
        tomorrow=(Button)findViewById(R.id.button2);
        final Context context = this;

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Today1.class);
                startActivity(intent);
            }
        });
        tomorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Today1.class);
                startActivity(intent);
            }
        });
    }
}

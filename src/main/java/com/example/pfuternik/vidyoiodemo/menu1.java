package com.example.pfuternik.vidyoiodemo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class menu1 extends AppCompatActivity {
    private Button videocall;
    private Button uploadfile;
    private Button schedule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        videocall=(Button)findViewById(R.id.button1);
        uploadfile=(Button)findViewById(R.id.button2);
        schedule=(Button)findViewById(R.id.button3);
        final Context context = this;

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Doctor1.class);
                startActivity(intent);
            }
        });
        uploadfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Upload1.class);
                startActivity(intent);
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Schedule1.class);
                startActivity(intent);
            }
        });
    }
}

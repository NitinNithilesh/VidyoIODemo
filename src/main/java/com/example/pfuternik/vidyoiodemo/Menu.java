package com.example.pfuternik.vidyoiodemo;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {
    private Button doctor1;
    private Button doctor2;
    private Button doctor3;
    private Button doctor4;
    private Button doctor5;
    private Button doctor6;
    private Button doctor7;
    private Button doctor8;
    private Button doctor9;
    private Button doctor10;
    private Button doctor11;
    private Button doctor12;
    private Button doctor13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        doctor1=(Button)findViewById(R.id.button1);
        doctor2=(Button)findViewById(R.id.button2);
        doctor3=(Button)findViewById(R.id.button3);
        doctor4=(Button)findViewById(R.id.button4);
        doctor5=(Button)findViewById(R.id.button5);
        doctor6=(Button)findViewById(R.id.button6);
        doctor7=(Button)findViewById(R.id.button7);
        doctor8=(Button)findViewById(R.id.button8);
        doctor9=(Button)findViewById(R.id.button9);
        doctor10=(Button)findViewById(R.id.button10);
        doctor11=(Button)findViewById(R.id.button11);
        doctor12=(Button)findViewById(R.id.button12);
        doctor13=(Button)findViewById(R.id.button13);

        final Context context = this;

        doctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "cardiology");
                startActivity(intent);
            }
        });
        doctor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "ent");
                startActivity(intent);
            }
        });
        doctor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "general_medicine");
                startActivity(intent);
            }
        });
        doctor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "gynaecology");
                startActivity(intent);
            }
        });
        doctor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "nephrology");
                startActivity(intent);
            }
        });
        doctor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "neurology");
                startActivity(intent);
            }
        });
        doctor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "oncology");
                startActivity(intent);
            }
        });
        doctor8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "psychiatry");
                startActivity(intent);
            }
        });
        doctor9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Calendar.class);
                intent.putExtra("department", "orthopaedics");
                startActivity(intent);
            }
        });
        doctor10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "pulmonology");
                startActivity(intent);
            }
        });
        doctor11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "urology");
                startActivity(intent);
            }
        });
        doctor12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "paediatrics");
                startActivity(intent);
            }
        });
        doctor13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Calendar.class);
                intent.putExtra("department", "dentistry");
                startActivity(intent);
            }
        });


    }
}

package com.example.pfuternik.vidyoiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class Form extends AppCompatActivity {
    Button agree;
    CheckBox rule1, rule2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        agree = (Button) findViewById(R.id.agree);
        rule1 = (CheckBox) findViewById(R.id.radio1);
        rule2 = (CheckBox) findViewById(R.id.radio2);
        final Context context = this;


        agree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rule1.isChecked() && rule2.isChecked()){
                    Intent intent = new Intent(context, Register.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(Form.this, "Please agree !", Toast.LENGTH_SHORT).show();
                }
            }
        });

       }

     }


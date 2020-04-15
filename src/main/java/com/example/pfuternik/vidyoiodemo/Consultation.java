package com.example.pfuternik.vidyoiodemo;

import android.content.Context;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.Calendar;

public class Consultation extends AppCompatActivity {
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
    private DatabaseReference uDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        doctor1=(Button)findViewById(R.id.button1);
        doctor1.setEnabled(false);
        doctor1.setAlpha(.5f);
        doctor2=(Button)findViewById(R.id.button2);
        doctor2.setEnabled(false);
        doctor2.setAlpha(.5f);
        doctor3=(Button)findViewById(R.id.button3);
        doctor3.setEnabled(false);
        doctor3.setAlpha(.5f);
        doctor4=(Button)findViewById(R.id.button4);
        doctor4.setEnabled(false);
        doctor4.setAlpha(.5f);
        doctor5=(Button)findViewById(R.id.button5);
        doctor5.setEnabled(false);
        doctor5.setAlpha(.5f);
        doctor6=(Button)findViewById(R.id.button6);
        doctor6.setEnabled(false);
        doctor6.setAlpha(.5f);
        doctor7=(Button)findViewById(R.id.button7);
        doctor7.setEnabled(false);
        doctor7.setAlpha(.5f);
        doctor8=(Button)findViewById(R.id.button8);
        doctor8.setEnabled(false);
        doctor8.setAlpha(.5f);
        doctor9=(Button)findViewById(R.id.button9);
        doctor9.setEnabled(false);
        doctor9.setAlpha(.5f);
        doctor10=(Button)findViewById(R.id.button10);
        doctor10.setEnabled(false);
        doctor10.setAlpha(.5f);
        doctor11=(Button)findViewById(R.id.button11);
        doctor11.setEnabled(false);
        doctor11.setAlpha(.5f);
        doctor12=(Button)findViewById(R.id.button12);
        doctor12.setEnabled(false);
        doctor12.setAlpha(.5f);
        doctor13=(Button)findViewById(R.id.button13);
        doctor13.setEnabled(false);
        doctor13.setAlpha(.5f);

        final Context context = this;

        Calendar today = Calendar.getInstance();
        final Integer day = new Integer(today.get(Calendar.DAY_OF_MONTH));
        final Integer month = new Integer((today.get(Calendar.MONTH))+1);
        final Integer year = new Integer(today.get(Calendar.YEAR));
        final Integer hour = new Integer(today.get(Calendar.HOUR_OF_DAY));
        final Integer minutes = new Integer(today.get(Calendar.MINUTE));
        final Integer seconds = new Integer(today.get(Calendar.SECOND));
         System.out.println(" Day :"+day+" "+month+" "+year+" "+hour+" "+minutes+" "+seconds);

        final String userUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        uDatabase = FirebaseDatabase.getInstance().getReference().child("patients").child(userUid);
        uDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final String department = dataSnapshot.child("department").getValue(String.class);
                final Integer day1 = new Integer(dataSnapshot.child("slot").child("day").getValue(Integer.class));
                final Integer month1 =new Integer (dataSnapshot.child("slot").child("month").getValue(Integer.class));
                final Integer year1 = new Integer(dataSnapshot.child("slot").child("year").getValue(Integer.class));
                final Integer hour1 = new Integer(dataSnapshot.child("slot").child("hour").getValue(Integer.class));
                final Integer minute1 = new Integer(dataSnapshot.child("slot").child("minute").getValue(Integer.class));

                System.out.println(" Day1 :"+day1+" "+month1+" "+year1+" "+hour1+" "+minute1);

                if(day.equals(day1) && month.equals(month1) && year.equals(year1) && hour.equals(hour1)) {
                    System.out.println("times match");
                    if( (minute1==0 && minutes>=0 && minutes<30) || (minute1==30 && minutes>=30 && minutes<60 )) {
                        Toast.makeText(getApplicationContext(), "activated " + department, Toast.LENGTH_SHORT).show();
                        if (department.equals("cardiology")) {
                            doctor1.setEnabled(true);
                            doctor1.setAlpha(1f);
                        }
                        if (department.equals("ent")) {
                            doctor2.setEnabled(true);
                            doctor2.setAlpha(1f);
                        }
                        if (department.equals("general_medicine")) {
                            doctor3.setEnabled(true);
                            doctor3.setAlpha(1f);
                        }
                        if (department.equals("gynaecology")){
                            doctor4.setEnabled(true);
                            doctor4.setAlpha(1f);
                        }
                        if (department.equals("nephrology")){
                            doctor5.setEnabled(true);
                            doctor5.setAlpha(1f);
                        }
                        if (department.equals("neurology")){
                            doctor6.setEnabled(true);
                            doctor6.setAlpha(1f);
                        }
                        if (department.equals("oncology")){
                            doctor7.setEnabled(true);
                            doctor7.setAlpha(1f);
                        }
                        if (department.equals("psychiatry")){
                            doctor8.setEnabled(true);
                            doctor8.setAlpha(1f);
                        }
                        if (department.equals("orthopaedics")){
                            doctor9.setEnabled(true);
                            doctor9.setAlpha(1f);
                        }
                        if (department.equals("pulmonology")){
                            doctor10.setEnabled(true);
                            doctor10.setAlpha(1f);
                        }
                        if (department.equals("urology")){
                            doctor11.setEnabled(true);
                            doctor11.setAlpha(1f);
                        }
                        if (department.equals("paediatrics")){
                            doctor12.setEnabled(true);
                            doctor12.setAlpha(1f);
                        }
                        if (department.equals("dentistry")){
                            doctor13.setEnabled(true);
                            doctor13.setAlpha(1f);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Please wait for your appointment time for the buttons to be activated.", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please wait for your appointment day for the buttons to be activated.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        doctor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu1.class);
                startActivity(intent);
            }
        });
        doctor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, newmenu2.class);
                startActivity(intent);
            }
        });
        doctor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu3.class);
                startActivity(intent);
            }
        });
        doctor4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu4.class);
                startActivity(intent);
            }
        });
        doctor5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu5.class);
                startActivity(intent);
            }
        });
        doctor6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu6.class);
                startActivity(intent);
            }
        });
        doctor7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu7.class);
                startActivity(intent);
            }
        });
        doctor8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu8.class);
                intent.putExtra("department", "psychiatry");
                startActivity(intent);
            }
        });
        doctor9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,menu9.class);
                intent.putExtra("department", "orthopaedics");
                startActivity(intent);
            }
        });
        doctor10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu10.class);
                startActivity(intent);
            }
        });
        doctor11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu11.class);
                startActivity(intent);
            }
        });
        doctor12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu12.class);
                startActivity(intent);
            }
        });
        doctor13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, menu13.class);
                startActivity(intent);
            }
        });


    }
}

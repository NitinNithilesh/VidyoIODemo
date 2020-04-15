package com.example.pfuternik.vidyoiodemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Calendar extends AppCompatActivity {
    DatePicker picker;
    Button btnGet;
    private DatabaseReference mDatabase, uDatabase;
    private Spinner spinner,spinner1;
    String[] time_array = {"10:00", "10:30", "11:00","11:30", "13:00", "13:30", "14:00", "14:30", "15:00","15:30", "16:00", "16:30","17:00", "17:30","18:00","18:30"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        picker = (DatePicker) findViewById(R.id.datePicker1);
        btnGet = (Button) findViewById(R.id.button1);
        spinner = (Spinner) findViewById(R.id.spinner);
        final Context context1 = this;
        Intent intent = getIntent();

        final String department = intent.getStringExtra("department");

        ArrayAdapter adapter1 = new ArrayAdapter(Calendar.this, android.R.layout.simple_spinner_item, time_array);
        spinner.setAdapter(adapter1);


        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String time = spinner.getSelectedItem().toString();
                final String[] arrOfStr = time.split(":");
                final String date =picker.getYear() + "/" + (picker.getMonth() + 1) + "/" + picker.getDayOfMonth();
                mDatabase = FirebaseDatabase.getInstance().getReference().child("appointments").child(department);
                DatabaseReference check = mDatabase.child(date).child(arrOfStr[0]+"/"+arrOfStr[1]);
                check.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(!dataSnapshot.exists()) {
                            final String userUid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            uDatabase = FirebaseDatabase.getInstance().getReference().child("patients").child(userUid);
                            uDatabase.child("department").setValue(department);
                            uDatabase.child("slot").child("day").setValue(picker.getDayOfMonth());
                            uDatabase.child("slot").child("month").setValue(picker.getMonth()+1);
                            uDatabase.child("slot").child("year").setValue(picker.getYear());
                            uDatabase.child("slot").child("hour").setValue(Integer.parseInt(arrOfStr[0]));
                            uDatabase.child("slot").child("minute").setValue(Integer.parseInt(arrOfStr[1]));
                            uDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    final String username = dataSnapshot.child("username").getValue(String.class);
                                    Toast.makeText(getApplicationContext(), "The selected slot is available. Proceed to payment.", Toast.LENGTH_SHORT).show();
                                    mDatabase.child(date).child(arrOfStr[0]+"/"+arrOfStr[1]).child("userid").setValue(userUid);
                                    mDatabase.child(date).child(arrOfStr[0]+"/"+arrOfStr[1]).child("username").setValue(username);
                                    Intent intent1 = new Intent(context1, Pay1.class);
                                    startActivity(intent1);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });

                        }
                        else
                        {
                            Toast.makeText(context1, "The selected slot is unavailable. Please choose another slot.", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

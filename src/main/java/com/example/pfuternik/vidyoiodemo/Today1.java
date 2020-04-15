package com.example.pfuternik.vidyoiodemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Today1 extends AppCompatActivity {
    private Spinner spinner;
    private DatabaseReference mDatabase;
    private Button btn_submit;
//    String [] gender_array={"Male","Female","Others"};
//    DatabaseReference rootRef, demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("entered oncreate");
        setContentView(R.layout.activity_today1);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("timings").child("general_medicine");
        spinner = (Spinner)findViewById(R.id.spinner);

//        ArrayAdapter adapter1 = new ArrayAdapter(Today1.this, android.R.layout.simple_spinner_item, gender_array);
//        spinner.setAdapter(adapter1);
        System.out.println("initialized mdatabase:"+mDatabase);
           mDatabase.addValueEventListener(new ValueEventListener()  {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println("entered ondatachange"+dataSnapshot);
                final List<String> titleList = new ArrayList<String>();
                System.out.println("count of children is:"+dataSnapshot.getChildrenCount());
                System.out.println("children are:"+dataSnapshot.getChildren());
                 for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                      String occupied = dataSnapshot1.child("occupied").getValue(String.class);
                      if(occupied.equals("false")) {
                         String titlename = dataSnapshot1.child("slot").getValue(String.class);
                         titleList.add(titlename);
                         System.out.println("value is: "+titlename);
                     }

                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Today1.this, android.R.layout.simple_spinner_item, titleList);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(arrayAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Today1.this,databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String selected_slot = spinner.getSelectedItem().toString();
                mDatabase.child(selected_slot).child("occupied").setValue("true");
                Toast.makeText(getApplicationContext(), "The selected slot is available. Proceed to payment.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Today1.this, Pay1.class));
            }
        });
    }
}
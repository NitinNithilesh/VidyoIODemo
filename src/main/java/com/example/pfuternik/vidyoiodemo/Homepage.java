package com.example.pfuternik.vidyoiodemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                final Context context = this;
                Intent intent = new Intent(this, com.example.pfuternik.vidyoiodemo.Menu.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent1 = new Intent(this, com.example.pfuternik.vidyoiodemo.Consultation.class);
                startActivity(intent1);
                return true;
                case R.id.item3:
                    final Context context2 = this;
                    FirebaseAuth.getInstance().signOut();
                    Intent intent2 = new Intent(context2, Login.class);
                    startActivity(intent2);
                    return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
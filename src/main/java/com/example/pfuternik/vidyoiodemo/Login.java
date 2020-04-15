package com.example.pfuternik.vidyoiodemo;

import android.os.Bundle;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;


//public class Login extends AppCompatActivity implements OnClickListener
//{
//    EditText editText1,editText2;
//    Button button;
//    SQLiteDatabase db;
//    @Override
//    public void onCreate(Bundle savedInstanceState)
//    {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        editText1=(EditText)findViewById(R.id.editText1);
//        editText2=(EditText)findViewById(R.id.editText2);
//
//
//        button=(Button)findViewById(R.id.button);
//
//        button.setOnClickListener(this);
//
//        db=openOrCreateDatabase("hospital", Context.MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS user_log(phone VARCHAR);");
//    }
//    public void onClick(View view)
//    {
//        if(view==button) {
//            if(editText1.getText().toString().trim().length()==0 || editText2.getText().toString().trim().length()==0)
//            {
//                Toast.makeText(this, "Please Enter all the Values", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            if(editText1.getText().toString().length()==10) {
//                Cursor c = db.rawQuery("SELECT * FROM patients WHERE phone='" + editText1.getText() + "' AND password='"+editText2.getText()+"'", null);
//                if (c.moveToNext()) {
//                    db.execSQL("INSERT INTO user_log VALUES('" + editText2.getText() + "');");
//                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
//                    final Context context = this;
//                    Intent intent = new Intent(context, Menu.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(this, "Mobile Number or Password is wrong. Please Check It", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            }
//            else{
//                Toast.makeText(this, "Please Enter a Valid Mobile Number", Toast.LENGTH_SHORT).show();
//            }
//
//        }
//
//    }
//}
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private Button btnSignup, btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Login.this, Homepage.class));
            finish();
        }

        // set the view now
        setContentView(R.layout.activity_login);


        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnReset = (Button) findViewById(R.id.btn_reset);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Form.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ResetPasswordActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }


                //authenticate user
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        inputPassword.setError(getString(R.string.minimum_password));
                                    } else {
                                        Toast.makeText(Login.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(Login.this, Homepage.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });
            }
        });
    }
}

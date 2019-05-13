package com.example.coffeeapp.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText loginEmail;
    EditText loginPassword;
    Button loginBtn;
    Button registerBtn;
    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        loginBtn = (Button) findViewById(R.id.loginButton);
        registerBtn = (Button) findViewById(R.id.RegisterButton);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyUser();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }


    public void verifyUser() {
        mAuth = FirebaseAuth.getInstance();

        final ProgressDialog progressDialog = ProgressDialog
                .show(this, "Please wait...", "Processing...", true);
        mAuth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPassword.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            //initUser();
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), ProductListActivity.class);
                            startActivity(i);
                        } else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    /*public void initUser() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase("https://coffeeapp-5c37f.firebaseio.com/Users");
        User.getInstance().setmCredit(Integer.valueOf(stringBalance));
        ref.addListenerForSingleValueEvent(new ValueEventListener() {



            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name = dataSnapshot.child(mAuth.getUid()).child("name").getValue().toString();
                stringBalance = dataSnapshot.child(mAuth.getUid()).child("balance").getValue().toString();
                int balance = Integer.parseInt(stringBalance);
                //User.getInstance().setmCredit(balance);
                Toast.makeText(getApplicationContext(), stringBalance, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
*/
   // }
}

package com.example.coffeeapp.controller;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private EditText Email, Password, Name;
    private Button registerButton;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mProgress = new ProgressDialog(this);
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);
        Name = (EditText) findViewById(R.id.name);
        registerButton = (Button) findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
                startRegister();
            }
        });

    }

    private void startRegister() {
        final String name = Name.getText().toString();
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(email)) {

            mProgress.setMessage("Signing up...");
            mProgress.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {

                        String userId = mAuth.getCurrentUser().getUid();
                        User user = new User();
                        user.setmUserName(name);
                        user.setmUUID(userId);

                        DatabaseReference current_user = mDatabase.child(userId);
                        current_user.child("name").setValue(name);
                        current_user.child("balance").setValue("$0");
                        current_user.child("favourite");
                        mProgress.dismiss();
                    }
                }
            });
        }
    }

}

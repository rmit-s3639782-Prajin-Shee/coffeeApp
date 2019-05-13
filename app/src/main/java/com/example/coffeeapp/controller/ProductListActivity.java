package com.example.coffeeapp.controller;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.User;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProductListActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    String stringBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        initUser();

        BottomNavigationView navigationView = findViewById(R.id.bottomNav);
        final ProductListFragment productListFragment = new ProductListFragment();
        final OrderHistoryFragment orderHistoryFragment = new OrderHistoryFragment();
        setFragment(productListFragment);

        Toolbar toolbar = findViewById(R.id.toolbar);

        //String stringName = User.getInstance().getmUserName();
        // Toast.makeText(this,Integer.toString(intCredit),Toast.LENGTH_LONG).show();
        setSupportActionBar(toolbar);


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.products) {
                    setFragment(productListFragment);
                    return true;
                } else if (id == R.id.history) {
                    setFragment(orderHistoryFragment);
                    return true;
                }
                return false;
            }
        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }


    public void initUser() {
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Firebase.setAndroidContext(this);
        Firebase ref = new Firebase("https://coffeeapp-5c37f.firebaseio.com/Users");

        ref.addListenerForSingleValueEvent(new ValueEventListener() {


            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child(mAuth.getUid()).child("name").getValue().toString();
                stringBalance = dataSnapshot.child(mAuth.getUid()).child("balance").getValue().toString();
                TextView credit = findViewById(R.id.productListCredit);
                credit.setText(stringBalance);
                User.getInstance().setmCredit(Integer.valueOf(stringBalance));
                Toast.makeText(getApplicationContext(), "$" + User.getInstance().getmCredit(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}

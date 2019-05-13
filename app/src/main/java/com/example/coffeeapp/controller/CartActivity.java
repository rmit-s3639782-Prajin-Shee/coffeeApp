package com.example.coffeeapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.Cart;
import com.example.coffeeapp.model.CoffeeItem;
import com.example.coffeeapp.model.OrderItems;
import com.example.coffeeapp.model.User;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private CartRecyclerAdapter cartRecyclerAdapter;
    private Button confirmButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        mRecyclerView = findViewById(R.id.cartRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cartRecyclerAdapter = new CartRecyclerAdapter(Cart.getInstance().getCartItemsArrayList(), this);
        mRecyclerView.setAdapter(cartRecyclerAdapter);

        confirmButton = (Button)findViewById(R.id.confirmBtn);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User.getInstance().getmCredit()>=2){
                    User.getInstance().setmCredit(User.getInstance().getmCredit()-2);
                    Toast.makeText(getApplicationContext(),"Success "+ User.getInstance().getmCredit(),Toast.LENGTH_LONG).show();
                    //Intent intent = new Intent (getApplicationContext(), ProductListActivity.class);
                    //startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Failed "+User.getInstance().getmCredit(),Toast.LENGTH_LONG).show();

                }
            }
        });



    }
}

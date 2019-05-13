package com.example.coffeeapp.controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.CoffeeItem;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DatabaseReference mDatabase;
    private ArrayList <CoffeeItem> coffeeItems = new ArrayList<>();
    private Firebase mRef;
    private ProductListAdapter productListAdapter;
    private FloatingActionButton fab;


    public ProductListFragment() {
        // Required empty public constructor
    }

    public void intializeList(){
        Firebase.setAndroidContext(getContext());
        mRef =  new Firebase("https://coffeeapp-5c37f.firebaseio.com/CoffeList");
        Firebase.setAndroidContext(getContext());

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String name = dataSnapshot.getKey();
                String desc = dataSnapshot.getValue().toString();
                coffeeItems.add(new CoffeeItem(name,desc, R.drawable.cofe_icon));
                productListAdapter.notifyDataSetChanged();


            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        intializeList();
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);
        coffeeItems.clear();

        fab = view.findViewById(R.id.productListFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "HI", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),CartActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView = view.findViewById(R.id.ProductListRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        productListAdapter = new ProductListAdapter(coffeeItems, getContext());
        mRecyclerView.setAdapter(productListAdapter);

        return view;
    }

}

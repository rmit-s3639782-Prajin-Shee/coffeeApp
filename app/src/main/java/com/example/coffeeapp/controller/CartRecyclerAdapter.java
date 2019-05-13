package com.example.coffeeapp.controller;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.CoffeeItem;
import com.example.coffeeapp.model.OrderItems;

import java.util.ArrayList;

public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.ViewHolder> {
    private ArrayList<OrderItems> orderItems = new ArrayList<>();
    private Context context;

    public CartRecyclerAdapter(ArrayList<OrderItems> orderItems, Context context) {
        this.orderItems = orderItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final OrderItems orderItem = orderItems.get(i);
        viewHolder.name.setText(orderItem.getCoffeeName());
        viewHolder.desc.setText(orderItem.getCoffeeSpecifcations());

    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView desc;
        ImageView img;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.coffeeName);
            desc = itemView.findViewById(R.id.coffeeDesc);
            img = itemView.findViewById(R.id.coffeeImg);
            cardView = (CardView) itemView.findViewById(R.id.productCardView);
        }
    }
}

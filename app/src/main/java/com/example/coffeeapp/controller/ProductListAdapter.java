package com.example.coffeeapp.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coffeeapp.R;
import com.example.coffeeapp.model.CoffeeItem;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private ArrayList<CoffeeItem> coffeeItems = new ArrayList<>();
    private Context context;

    public ProductListAdapter(ArrayList<CoffeeItem> coffeeItems, Context context) {
        this.coffeeItems = coffeeItems;
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
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final CoffeeItem coffeeItem = coffeeItems.get(i);
        viewHolder.name.setText(coffeeItem.getCoffeeName());
        viewHolder.desc.setText(coffeeItem.getCoffeeDesc());
        viewHolder.img.setImageResource(coffeeItem.getCoffeeImg());

        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, coffeeItem.getCoffeeName() +"", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,CoffeeSettingsActivity.class);
                intent.putExtra("Coffee Name", coffeeItem.getCoffeeName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffeeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

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

package com.example.coffeeapp.model;

import java.util.ArrayList;

public class Cart {
    private static Cart cartInstance;
    private ArrayList<OrderItems> cartItemsArrayList;

    public static Cart getInstance(){
        if(cartInstance==null){
            cartInstance = new Cart();
        }
        return cartInstance;
    }

    private Cart(){
        cartItemsArrayList = new ArrayList<OrderItems>();
    }

    public ArrayList<OrderItems> getCartItemsArrayList(){
        return this.cartItemsArrayList;
    }

    public void addCartItemToList(OrderItems cartItems){
        cartItemsArrayList.add(cartItems);
    }

}

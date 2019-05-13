package com.example.coffeeapp.model;


import java.util.ArrayList;

public class Order {

    private static Order orderInstance;
    private ArrayList<OrderItems> orderItemsArrayList;

    public static Order getInstance(){
        if(orderInstance==null){
            orderInstance = new Order();
        }
        return orderInstance;
    }

    private Order(){
        orderItemsArrayList = new ArrayList<OrderItems>();
    }

    public ArrayList<OrderItems> getOrderItemsArrayList(){
        return this.orderItemsArrayList;
    }

    public void addOrderItemToList(OrderItems orderItems){
        orderItemsArrayList.add(orderItems);
    }

}

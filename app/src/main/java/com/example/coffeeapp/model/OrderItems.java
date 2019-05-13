package com.example.coffeeapp.model;

public class OrderItems {

    String CoffeeName;
    String CoffeeSpecifcations;

    public OrderItems(String coffeeName, String coffeeSpecifcations) {
        CoffeeName = coffeeName;
        CoffeeSpecifcations = coffeeSpecifcations;
    }

    public String getCoffeeName() {
        return CoffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        CoffeeName = coffeeName;
    }

    public String getCoffeeSpecifcations() {
        return CoffeeSpecifcations;
    }

    public void setCoffeeSpecifcations(String coffeeSpecifcations) {
        CoffeeSpecifcations = coffeeSpecifcations;
    }
}

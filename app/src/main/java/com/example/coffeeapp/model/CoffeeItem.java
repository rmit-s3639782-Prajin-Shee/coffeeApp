package com.example.coffeeapp.model;

public class CoffeeItem {

    String coffeeName;
    String coffeeDesc;
    int coffeeImg;

    CoffeeItem(){

    }

    public CoffeeItem(String coffeeName, String coffeeDesc, int coffeeImg) {
        this.coffeeName = coffeeName;
        this.coffeeDesc = coffeeDesc;
        this.coffeeImg = coffeeImg;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public String getCoffeeDesc() {
        return coffeeDesc;
    }

    public void setCoffeeDesc(String coffeeDesc) {
        this.coffeeDesc = coffeeDesc;
    }

    public int getCoffeeImg() {
        return coffeeImg;
    }

    public void setCoffeeImg(int coffeeImg) {
        this.coffeeImg = coffeeImg;
    }
}

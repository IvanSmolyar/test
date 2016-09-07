package com.test.ivan.struct.decorator;

public class SimpleCoffe implements Coffee {

    @Override
    public double getCost() {
        return 2;
    }

    @Override
    public String getIngredients() {
        return "coffee, water";
    }
}

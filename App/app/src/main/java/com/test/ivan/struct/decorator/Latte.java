package com.test.ivan.struct.decorator;

public class Latte extends CoffeDecorator{

    public Latte(Coffee c) {
        super(c);
    }

    public double getCost() {
        return super.getCost() + 0.5;
    }

    public String getIngredients() {
        return super.getIngredients() + ", Milk";
    }
}

package com.test.ivan.struct.decorator;

public abstract class CoffeDecorator implements Coffee {
    protected final Coffee decoratedCoffee;

    public CoffeDecorator(Coffee c) {
        this.decoratedCoffee = c;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }

    public String getIngredients() {
        return decoratedCoffee.getIngredients();
    }
}

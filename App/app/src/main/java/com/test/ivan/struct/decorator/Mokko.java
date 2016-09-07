package com.test.ivan.struct.decorator;

public class Mokko extends Latte {

    public Mokko(Coffee c) {
        super(c);
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + ", chocolate";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.3;
    }
}

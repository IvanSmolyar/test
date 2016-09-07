package com.test.ivan.behavioral.strategy;

public class Multiply implements Operation{
    @Override
    public int doOperation(int var1, int var2) {
        return var1 * var2;
    }
}

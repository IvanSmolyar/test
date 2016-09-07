package com.test.ivan.behavioral.strategy;

public class Math {

    private Operation mOperation;

    public Math(Operation operation) {
        mOperation = operation;
    }

    public int apply(int a, int b) {
        return mOperation.doOperation(a, b);
    }
}

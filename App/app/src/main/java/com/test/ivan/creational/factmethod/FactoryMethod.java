package com.test.ivan.creational.factmethod;

public abstract class FactoryMethod extends FactoryMethodObject {

    protected FactoryMethod() {
    }

    public static FactoryMethodObject getInstance() {
        return getDefaultObjectInstance();
    }

    public static FactoryMethodObject getInstance(String string) {
        return getObjectInstance(string);
    }

    private static FactoryMethodObject getDefaultObjectInstance() {
        return new FactoryMethodObject();
    }

    private static FactoryMethodObject getObjectInstance(String s) {
        return getObjectInstance(s);
    }
}

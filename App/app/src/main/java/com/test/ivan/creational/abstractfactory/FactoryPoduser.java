package com.test.ivan.creational.abstractfactory;

public class FactoryPoduser {
    public static AbstractFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();

        }

        return null;
    }
}

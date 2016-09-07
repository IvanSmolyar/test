package com.test.ivan.creational.abstractfactory;

public class ShapeFactory extends AbstractFactory{

    @Override
    public Color getColor(String color) {
        return new Red();
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }

        if(shapeType.equalsIgnoreCase("circ")){
            return new Circle();

        }else if(shapeType.equalsIgnoreCase("rect")){
            return new Rect();

        }

        return null;
    }
}

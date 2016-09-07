package com.test.ivan.struct.bridge;

public abstract class Shape {

    protected BaseDraw mDraw;

    protected Shape(BaseDraw d) {
        mDraw = d;
    }

    public abstract void draw();
    public abstract void resize();
}

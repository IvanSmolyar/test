package com.test.ivan.creational.prototype;

public class Prototype {

    protected Object copy() throws CloneNotSupportedException {
        if (!(this instanceof Copyable)) {
            throw new IllegalStateException("Class " + getClass().getName() +
                    " doesn't implement Copyable");
        }

        Object copy = this;
        return copy;
    }
}

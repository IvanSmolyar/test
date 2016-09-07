package com.test.ivan.creational.factmethod;

public class FactoryMethodObject  {

    private String mString;

    protected FactoryMethodObject() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FactoryMethodObject that = (FactoryMethodObject) o;

        return mString != null ? mString.equals(that.mString) : that.mString == null;

    }

    @Override
    public int hashCode() {
        return mString != null ? mString.hashCode() : 0;
    }
}

package com.test.ivan.creational.builder;

/**
 * Created by user on 06.09.2016.
 */
public class Builder extends BuilderModel {

    public void setField1(String field1) {
        this.setField1(field1);
    }

    public void setField2(String field2) {
        this.setField2(field2);
    }

    public void setField3(String field3) {
        this.setField1(field3);
    }

    public void setField4(String field4) {
        this.setField1(field4);
    }

    public BuilderModel create() {
        return this;
    }
}

package com.test.ivan.behavioral.templatemethod;

import android.content.Context;
import android.util.AttributeSet;

public class AnotherView extends BaseView {

    public AnotherView(Context context) {
        super(context);
    }

    public AnotherView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AnotherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTheme() {
        if (mParam1.equals("3")) {

        }

        if (mParam2.equals("546")) {

        }
    }

    @Override
    public String setResultMessage() {
        if (mParam1.equals("321")) {
            return "";
        }

        if (mParam2.equals("w")) {
            return "";
        }
        return "";
    }
}

package com.test.ivan.behavioral.templatemethod;

import android.content.Context;
import android.util.AttributeSet;

public class SomeView extends BaseView {

    public SomeView(Context context) {
        super(context);
    }

    public SomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SomeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTheme() {
        if (mParam1.equals("1")) {

        }

        if (mParam2.equals("2")) {

        }
    }

    @Override
    public String setResultMessage() {
        if (mParam1.equals("1")) {
            return "";
        }

        if (mParam2.equals("2")) {
            return "";
        }
        return "";
    }
}

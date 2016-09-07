package com.test.ivan.behavioral.templatemethod;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class BaseView extends LinearLayout {

    protected ImageView iv;
    protected TextView tv;
    protected ImageView iv2;

    protected String mParam2;
    protected String mParam1;

    public BaseView(Context context) {
        this(context, null);
    }

    /**
     * Constructor for the Bill Payment Message View custom widget.
     *
     * @param context Context.
     * @param attrs   AttributeSet.
     */
    public BaseView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Constructor for the Bill Payment Message View custom widget.
     *
     * @param context      Context.
     * @param attrs        AttributeSet
     * @param defStyleAttr Default Style Attributes.
     */
    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        iv = new ImageView(getContext());
        tv = new TextView(getContext());
        iv2 = new ImageView(getContext());
    }

    public void setData(String s1, String s2) {
        mParam1 = s1;
        mParam2 = s2;

        postInit();
    }

    // this is template method
    private void postInit() {
        setTheme();
        setResultMessage();
        show();
    }

    private void show() {
        setVisibility(VISIBLE);
    }

    public abstract void setTheme();

    public abstract String setResultMessage();
}

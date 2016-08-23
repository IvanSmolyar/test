package com.test.ivan.app.ui.activity;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

import com.test.ivan.app.R;

public class ShareButton extends Button implements View.OnClickListener {

    private SocialNetworkApp mApp;

    private enum SocialNetworkApp {
        FACEBOOK("com.facebook.katana"),
        INSTAGRAM("com.instagram.android"),
        OTHER("other");

        private final String mPackageName;

        SocialNetworkApp(String appID) {
            mPackageName = appID;
        }

        public String getPackageName() {
            return mPackageName;
        }
    }

    public ShareButton(Context context) {
        this(context, null);
    }

    public ShareButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttrs(context, attrs);
        init();
    }

    private void applyAttrs(Context context, AttributeSet attrs) {
        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ShareButton, 0, 0);
        try {
            mApp = SocialNetworkApp.values()[ta.getInteger(R.styleable.ShareButton_network, SocialNetworkApp.FACEBOOK.ordinal())];
        } finally {
            ta.recycle();
        }
    }

    private void init() {
        setBackgroundResources();
        setOnClickListener(this);
        setEnabled(isApplicationInstalled());
    }

    private void setBackgroundResources() {
        switch (mApp) {
            case FACEBOOK:
                setBackgroundResource(R.drawable.button_back_facebook);
                break;
            case INSTAGRAM:
                setBackgroundResource(R.drawable.button_back_instagram);
                break;
            case OTHER:
                setBackgroundResource(R.mipmap.ic_share);
                break;
        }
    }

    private boolean isApplicationInstalled() {
        if (mApp == SocialNetworkApp.OTHER) {
            return true;
        }
        final PackageManager pm = getContext().getPackageManager();
        boolean res;
        try {
            pm.getPackageInfo(mApp.getPackageName(), PackageManager.GET_ACTIVITIES);
            res = true;
        } catch (PackageManager.NameNotFoundException e) {
            res = false;
        }
        return res;
    }

    @Override
    public void onClick(View v) {
        switch (mApp) {
            case FACEBOOK:
                break;
            case INSTAGRAM:
                break;
            case OTHER:
                break;
        }
    }
}

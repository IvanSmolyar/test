package com.test.ivan.behavioral.mediator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Mediator {

    private final Activity mActivity;

    public Mediator(Activity activity) {
        mActivity = activity;
    }

    protected void startActivity(Class<?> cls) {
        final Intent intent = new Intent(mActivity, cls);
        mActivity.startActivity(intent);
    }

    protected void startActivity(Class<?> cls, Bundle extras) {
        final Intent intent = new Intent(mActivity, cls);
        intent.replaceExtras(extras);
        mActivity.startActivity(intent);
    }
}

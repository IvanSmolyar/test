package com.test.ivan.behavioral.mediator;

import android.app.Activity;
import android.os.Bundle;

public class ActivityNavigator extends Mediator {

    public ActivityNavigator(Activity activity) {
        super(activity);
    }

    public void showSomeActivity() {
        startActivity(Activity.class);
    }

    public void showSomeActivity2(int categoryId) {
        final Bundle bundle = new Bundle();
        bundle.putInt("key", 123);
        startActivity(Activity.class, bundle);
    }

}

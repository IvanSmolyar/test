package com.test.ivan.app.ui.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.test.ivan.app.App;
import com.test.ivan.app.di.activity.ActivityComponent;
import com.test.ivan.app.di.app.ApplicationComponent;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected abstract void injectComponent(ActivityComponent component);

    public ActivityComponent getComponent() {
        return activityComponent;
    }
}

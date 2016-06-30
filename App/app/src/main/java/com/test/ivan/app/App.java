package com.test.ivan.app;

import android.app.Application;

import com.test.ivan.app.di.app.ApplicationComponent;
import com.test.ivan.app.di.app.ApplicationModule;
import com.test.ivan.app.di.app.DaggerApplicationComponent;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
public class App extends Application {

    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }
}

package com.test.ivan.app.di.activity;

import android.os.Handler;

import com.google.gson.Gson;
import com.test.ivan.app.di.app.ApplicationComponent;
import com.test.ivan.app.ui.ActivityNavigator;
import com.test.ivan.app.ui.activity.BaseActivity;
import com.test.ivan.app.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    Gson getGson();
    Handler getHandler();
    ActivityNavigator getActivityNavigator();
}

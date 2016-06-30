package com.test.ivan.app.di.activity;

import com.test.ivan.app.ui.ActivityNavigator;
import com.test.ivan.app.ui.activity.BaseActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@Module
public class ActivityModule {

    private final BaseActivity activity;

    public ActivityModule(BaseActivity activityIn) {
        activity = activityIn;
    }

    @Provides
    @PerActivity
    protected ActivityNavigator provideActivityNavigator() {
        return new ActivityNavigator(activity);
    }
}

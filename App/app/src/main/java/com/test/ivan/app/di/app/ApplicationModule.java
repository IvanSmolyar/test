package com.test.ivan.app.di.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.ivan.app.App;
import com.test.ivan.app.ui.ActivityNavigator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@Module
public class ApplicationModule {

    private App app;

    public ApplicationModule(final App appIn) {
        app = appIn;
    }

    @Provides
    @Singleton
    protected Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    protected Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    /**
     * Provides handler
     *
     * @return Handler
     */
    @Provides
    @Singleton
    protected Handler provideHandler() {
        return new Handler(Looper.getMainLooper());
    }

    @Provides
    @Singleton
    protected ExecutorService provideExecutorService() {
        return Executors.newCachedThreadPool();
    }

    @Provides
    @Singleton
    protected ActivityNavigator provideActivityNavigator() {
        return new ActivityNavigator(app);
    }
}

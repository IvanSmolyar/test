package com.test.ivan.app.di.app;

import android.os.Handler;

import com.google.gson.Gson;

import java.util.concurrent.ExecutorService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Gson getGson();
    Handler getHandler();
    ExecutorService getExecutorService();
}

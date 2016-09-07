package com.test.ivan.creational;

public final class Singleton {

    private volatile static Singleton sInstance;

    public static Singleton getInstance() {
        Singleton localInstance = sInstance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = sInstance = new Singleton();
            }
        }
        return localInstance;
    }
}

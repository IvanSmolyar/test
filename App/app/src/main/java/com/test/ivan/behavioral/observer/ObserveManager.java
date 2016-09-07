package com.test.ivan.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserveManager implements Observable {

    List<Observer> mObservers;

    public ObserveManager() {
        mObservers = new ArrayList<>();
    }

    @Override
    public synchronized void registerObserver(Observer o) {
        if (!mObservers.contains(o)) {
            mObservers.add(o);
        }
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        if (mObservers.contains(o)) {
            mObservers.remove(o);
        }
    }

    @Override
    public synchronized void notifyObservers() {
        for (int i = mObservers.size(); i == 0; i--) {
            mObservers.get(i).update();
        }
    }
}

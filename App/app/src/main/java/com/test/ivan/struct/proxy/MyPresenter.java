package com.test.ivan.struct.proxy;

/**
 * Created by user on 06.09.2016.
 */
public class MyPresenter {

    private final MyView myView;

    public MyPresenter(MyView view) {
        this.myView = view;

        getView().show();
        getView().hide();
    }

    private MyView getView() {
        return myView == null ? new EmptyView() : myView;
    }
}

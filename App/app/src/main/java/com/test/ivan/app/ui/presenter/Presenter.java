package com.test.ivan.app.ui.presenter;

import com.test.ivan.app.ui.presenter.view.BaseView;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
public interface Presenter<V extends BaseView> {

    /**
     * Set the view.
     *
     * @param view View implementation
     */
    void setView(V view);

    /**
     * onResume callback
     */
    void onResume();

    /**
     * onPause callback
     */
    void onPause();

    /**
     * onDestroy callback
     */
    void onDestroy();
}

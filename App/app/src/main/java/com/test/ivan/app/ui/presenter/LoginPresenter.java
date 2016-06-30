package com.test.ivan.app.ui.presenter;

import com.google.gson.Gson;
import com.test.ivan.app.ui.presenter.view.LoginView;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
public class LoginPresenter implements Presenter<LoginView> {

    private final Gson gson;
    private LoginView view;

    public LoginPresenter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public void setView(LoginView view) {
        this.view = view;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}

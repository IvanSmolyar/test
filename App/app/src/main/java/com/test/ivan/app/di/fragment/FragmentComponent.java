package com.test.ivan.app.di.fragment;

import com.test.ivan.app.di.activity.ActivityComponent;
import com.test.ivan.app.ui.fragment.BaseFragment;
import com.test.ivan.app.ui.fragment.LoginFragment;
import com.test.ivan.app.ui.presenter.LoginPresenter;

import dagger.Component;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@PerFragment
@Component(dependencies = ActivityComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    void inject(BaseFragment fragment);
    void inject(LoginFragment fragment);

    LoginPresenter getLoginPresenter();

}

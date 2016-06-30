package com.test.ivan.app.di.fragment;

import com.google.gson.Gson;
import com.test.ivan.app.ui.fragment.BaseFragment;
import com.test.ivan.app.ui.presenter.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ivan_Smaliar on 6/29/2016.
 */
@Module
public class FragmentModule {

    private BaseFragment fragment;

    public FragmentModule(BaseFragment fragmentIn) {
        fragment = fragmentIn;
    }

    @Provides
    @PerFragment
    protected LoginPresenter provideLoginPresenter(Gson gs) {
        return new LoginPresenter(gs);
    }
}

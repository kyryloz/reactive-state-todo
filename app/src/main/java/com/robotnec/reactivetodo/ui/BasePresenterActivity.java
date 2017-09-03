package com.robotnec.reactivetodo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.robotnec.reactivetodo.TodoApplication;
import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.mvp.presenter.Presenter;
import com.robotnec.reactivetodo.core.mvp.view.View;

import butterknife.ButterKnife;

public abstract class BasePresenterActivity<P extends Presenter<V>, V extends View>
        extends AppCompatActivity implements View {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        presenter = createPresenter();
        ApplicationComponent component = ((TodoApplication) getApplication()).getApplicationComponent();
        presenter.injectComponent(component);
        presenter.onViewCreate();
    }

    protected abstract P createPresenter();

    protected abstract int getLayoutId();
}

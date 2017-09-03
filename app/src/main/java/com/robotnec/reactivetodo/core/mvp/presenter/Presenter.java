package com.robotnec.reactivetodo.core.mvp.presenter;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.mvp.view.View;

public abstract class Presenter<T extends View> {

    protected final T view;

    Presenter(T view) {
        this.view = view;
    }

    public abstract void injectComponent(ApplicationComponent applicationComponent);
}

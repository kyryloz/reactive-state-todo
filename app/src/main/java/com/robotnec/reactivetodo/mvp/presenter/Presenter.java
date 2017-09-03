package com.robotnec.reactivetodo.mvp.presenter;

import com.robotnec.reactivetodo.di.ApplicationComponent;
import com.robotnec.reactivetodo.mvp.view.View;

/**
 * @author zak zak@swingpulse.com>
 */
public abstract class Presenter<T extends View> {

    public abstract void injectComponent(ApplicationComponent applicationComponent);

    public abstract void onViewCreate();
}

package com.robotnec.reactivetodo.core.mvp.presenter;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.mvp.view.View;

/**
 * @author zak zak@swingpulse.com>
 */
public abstract class Presenter<T extends View> {

    public abstract void injectComponent(ApplicationComponent applicationComponent);

    public abstract void onViewCreate();
}

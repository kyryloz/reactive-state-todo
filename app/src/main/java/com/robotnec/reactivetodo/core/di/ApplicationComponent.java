package com.robotnec.reactivetodo.core.di;

import com.robotnec.reactivetodo.core.di.module.AndroidModule;
import com.robotnec.reactivetodo.core.di.module.DaoModule;
import com.robotnec.reactivetodo.core.di.module.ServiceModule;
import com.robotnec.reactivetodo.core.mvp.presenter.TodoPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AndroidModule.class,
        DaoModule.class,
        ServiceModule.class
})
public interface ApplicationComponent {
    void inject(TodoPresenter presenter);
}

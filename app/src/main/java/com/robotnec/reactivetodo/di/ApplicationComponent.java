package com.robotnec.reactivetodo.di;

import com.robotnec.reactivetodo.di.module.AndroidModule;
import com.robotnec.reactivetodo.di.module.DaoModule;
import com.robotnec.reactivetodo.di.module.ServiceModule;
import com.robotnec.reactivetodo.mvp.presenter.TodoPresenter;

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

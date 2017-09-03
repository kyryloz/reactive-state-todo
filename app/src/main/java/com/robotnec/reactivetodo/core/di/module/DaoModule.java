package com.robotnec.reactivetodo.core.di.module;

import com.robotnec.reactivetodo.core.persistance.TodoDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @Singleton
    @Provides
    TodoDao provideAccountDao() {
        return null;
    }
}

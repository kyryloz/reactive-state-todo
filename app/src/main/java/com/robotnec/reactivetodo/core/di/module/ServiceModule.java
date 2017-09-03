package com.robotnec.reactivetodo.core.di.module;

import com.robotnec.reactivetodo.core.service.TodoService;
import com.robotnec.reactivetodo.core.service.TodoServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    TodoService provideMoneyOperationService() {
        return new TodoServiceImpl();
    }
}

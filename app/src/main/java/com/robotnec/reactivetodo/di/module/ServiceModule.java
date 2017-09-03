package com.robotnec.reactivetodo.di.module;

import android.util.Log;

import com.robotnec.reactivetodo.service.TodoService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {

    @Singleton
    @Provides
    TodoService provideMoneyOperationService() {
        return new TodoService() {
            @Override
            public void addTodo(String note) {
                Log.d("ServiceModule", "add todo: " + note);
            }
        };
    }
}

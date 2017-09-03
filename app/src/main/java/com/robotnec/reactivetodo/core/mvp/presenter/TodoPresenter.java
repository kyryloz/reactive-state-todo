package com.robotnec.reactivetodo.core.mvp.presenter;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.mvp.view.TodoView;
import com.robotnec.reactivetodo.core.service.TodoService;

import javax.inject.Inject;

public class TodoPresenter extends Presenter<TodoView> {

    @Inject
    TodoService todoService;

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    @Override
    public void onViewCreate() {

    }

    public void onFabClick() {
        todoService.addTodo("Hello World");
    }
}

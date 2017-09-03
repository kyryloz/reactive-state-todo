package com.robotnec.reactivetodo.mvp.presenter;

import com.robotnec.reactivetodo.di.ApplicationComponent;
import com.robotnec.reactivetodo.mvp.view.TodoView;
import com.robotnec.reactivetodo.service.TodoService;

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

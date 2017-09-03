package com.robotnec.reactivetodo.core.mvp.presenter;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.model.TodoModel;
import com.robotnec.reactivetodo.core.model.event.TodoEvent;
import com.robotnec.reactivetodo.core.mvp.view.TodoView;
import com.robotnec.reactivetodo.core.service.TodoService;

import javax.inject.Inject;

import io.reactivex.Observable;

public class TodoPresenter extends Presenter<TodoView> {

    @Inject
    TodoService todoService;

    public TodoPresenter(TodoView view) {
        super(view);
    }

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    public Observable<TodoModel> connect(Observable<TodoEvent> events) {
        return events.compose(todoService.toModelEvents());
    }
}

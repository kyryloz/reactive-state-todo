package com.robotnec.reactivetodo.core.mvp.presenter;

import com.robotnec.reactivetodo.core.di.ApplicationComponent;
import com.robotnec.reactivetodo.core.model.TodoModel;
import com.robotnec.reactivetodo.core.model.event.AddTodoEvent;
import com.robotnec.reactivetodo.core.model.event.RemoveTodoEvent;
import com.robotnec.reactivetodo.core.model.event.TodoEvent;
import com.robotnec.reactivetodo.core.model.result.Result;
import com.robotnec.reactivetodo.core.mvp.view.TodoView;
import com.robotnec.reactivetodo.core.service.TodoService;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class TodoPresenter extends Presenter<TodoView> {

    @Inject
    TodoService todoService;

    public TodoPresenter(TodoView view) {
        super(view);
        TodoModel initialState = TodoModel.initial();

        Observable<Result> results = null;

        Observable<TodoModel> todoModels = results
                .scan(initialState, (state, result) -> {
                    if (result == Result.SUCCESS) {
                        return TodoModel.success()
                    } else {
                        throw new UnsupportedOperationException();
                    }
                });
    }

    @Override
    public void injectComponent(ApplicationComponent applicationComponent) {
        applicationComponent.inject(this);
    }

    public Observable<TodoModel> connect(Observable<TodoEvent> events) {
        return events.compose(toModelEvents());
    }

    private ObservableTransformer<TodoEvent, TodoModel> toModelEvents() {
        ObservableTransformer<AddTodoEvent, TodoModel> addTodo = upstream -> upstream
                .flatMap(todoService::addTodo)
                .map(TodoModel::success)
                .onErrorReturn(t -> TodoModel.failure(todos, t.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(TodoModel.inProgress(todos));

        ObservableTransformer<RemoveTodoEvent, TodoModel> removeTodo = upstream -> upstream
                .flatMap(todoService::removeTodo)
                .map(TodoModel::success)
                .onErrorReturn(t -> TodoModel.failure(todos, t.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(TodoModel.inProgress(todos));

        return events -> events.publish(shared -> Observable.merge(
                shared.ofType(AddTodoEvent.class).compose(addTodo),
                shared.ofType(RemoveTodoEvent.class).compose(removeTodo)));
    }
}

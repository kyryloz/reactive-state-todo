package com.robotnec.reactivetodo.core.service;

import com.robotnec.reactivetodo.R;
import com.robotnec.reactivetodo.core.model.Todo;
import com.robotnec.reactivetodo.core.model.TodoModel;
import com.robotnec.reactivetodo.core.model.event.AddTodoEvent;
import com.robotnec.reactivetodo.core.model.event.RemoveTodoEvent;
import com.robotnec.reactivetodo.core.model.event.TodoEvent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class TodoServiceImpl implements TodoService {

    private final List<Todo> todos;

    public TodoServiceImpl() {
        todos = new ArrayList<>();
    }

    @Override
    public ObservableTransformer<TodoEvent, TodoModel> toModelEvents() {
        ObservableTransformer<AddTodoEvent, TodoModel> addTodo = upstream -> upstream
                .flatMap(this::addTodo)
                .map(TodoModel::success)
                .onErrorReturn(t -> TodoModel.failure(todos, t.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(TodoModel.inProgress(todos));

        ObservableTransformer<RemoveTodoEvent, TodoModel> removeTodo = upstream -> upstream
                .flatMap(this::removeTodo)
                .map(TodoModel::success)
                .onErrorReturn(t -> TodoModel.failure(todos, t.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .startWith(TodoModel.inProgress(todos));

        return events -> events.publish(shared -> Observable.merge(
                shared.ofType(AddTodoEvent.class).compose(addTodo),
                shared.ofType(RemoveTodoEvent.class).compose(removeTodo)));
    }

    private Observable<List<Todo>> addTodo(AddTodoEvent event) {
        return Observable.just(todos)
                .doOnSubscribe(disposable -> todos.add(new Todo(0, event.getText())));
    }

    private ObservableSource<List<Todo>> removeTodo(RemoveTodoEvent event) {
        return Observable.just(todos)
                .doOnSubscribe(disposable -> todos.remove(todos.size() - 1));
    }
}

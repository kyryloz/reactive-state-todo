package com.robotnec.reactivetodo.core.service;

import com.robotnec.reactivetodo.core.model.Todo;
import com.robotnec.reactivetodo.core.model.event.AddTodoEvent;
import com.robotnec.reactivetodo.core.model.event.RemoveTodoEvent;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class TodoServiceImpl implements TodoService {

    private final List<Todo> todos;

    public TodoServiceImpl() {
        todos = new ArrayList<>();
    }

    @Override
    public Observable<List<Todo>> addTodo(AddTodoEvent event) {
        return Observable.just(todos)
                .doOnSubscribe(disposable -> todos.add(new Todo(0, event.getText())));
    }

    @Override
    public ObservableSource<List<Todo>> removeTodo(RemoveTodoEvent event) {
        return Observable.just(todos)
                .doOnSubscribe(disposable -> todos.remove(todos.size() - 1));
    }
}

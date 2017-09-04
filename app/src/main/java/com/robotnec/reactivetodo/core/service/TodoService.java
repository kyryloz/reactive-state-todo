package com.robotnec.reactivetodo.core.service;

import com.robotnec.reactivetodo.core.model.Todo;
import com.robotnec.reactivetodo.core.model.event.AddTodoEvent;
import com.robotnec.reactivetodo.core.model.event.RemoveTodoEvent;
import com.robotnec.reactivetodo.core.model.result.Result;

import java.util.List;

import io.reactivex.Observable;

public interface TodoService {
    Observable<List<Todo>> getTodos();

    Observable<Result> addTodo(AddTodoEvent event);

    Observable<Result> removeTodo(RemoveTodoEvent event);
}

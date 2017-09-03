package com.robotnec.reactivetodo.core.service;

import com.robotnec.reactivetodo.core.model.TodoModel;
import com.robotnec.reactivetodo.core.model.event.TodoEvent;

import io.reactivex.ObservableTransformer;

public interface TodoService {
    ObservableTransformer<TodoEvent, TodoModel> toModelEvents();
}

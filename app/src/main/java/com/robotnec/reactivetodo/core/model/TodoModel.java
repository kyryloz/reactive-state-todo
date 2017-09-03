package com.robotnec.reactivetodo.core.model;

import java.util.Collections;
import java.util.List;

public class TodoModel {
    private final List<Todo> todos;
    private final String errorMessage;
    private final boolean inProgress;

    private TodoModel(List<Todo> todos, boolean inProgress, String errorMessage) {
        this.todos = todos;
        this.errorMessage = errorMessage;
        this.inProgress = inProgress;
    }

    public List<Todo> getTodos() {
        return Collections.unmodifiableList(todos);
    }

    public boolean isSuccess() {
        return !inProgress && todos != null;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public static TodoModel success(List<Todo> todos) {
        return new TodoModel(todos, false, null);
    }

    public static TodoModel failure(List<Todo> todos, String errorMessage) {
        return new TodoModel(todos, false, errorMessage);
    }

    public static TodoModel inProgress(List<Todo> todos) {
        return new TodoModel(todos, true, null);
    }
}

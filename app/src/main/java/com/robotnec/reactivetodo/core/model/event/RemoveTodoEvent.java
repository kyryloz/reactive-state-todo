package com.robotnec.reactivetodo.core.model.event;

public class RemoveTodoEvent implements TodoEvent {
    private final long todoId;

    public RemoveTodoEvent(long todoId) {
        this.todoId = todoId;
    }

    public long getTodoId() {
        return todoId;
    }
}

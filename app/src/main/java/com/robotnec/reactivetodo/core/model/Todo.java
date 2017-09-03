package com.robotnec.reactivetodo.core.model;

public class Todo {
    private final long id;
    private final String text;

    public Todo(long id, String text) {
        this.text = text;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}

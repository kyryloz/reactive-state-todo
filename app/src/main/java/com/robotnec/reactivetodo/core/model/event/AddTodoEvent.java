package com.robotnec.reactivetodo.core.model.event;

public class AddTodoEvent implements TodoEvent {
    private final String text;

    public AddTodoEvent(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

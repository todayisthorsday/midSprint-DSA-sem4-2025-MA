package com.keyin.model;

public class Task {
    private final String description;

    private Boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markCompleted() {
        this.isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public Boolean IsCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return (isCompleted ? "[✓] " : "[ ] ") + description;
    }
}

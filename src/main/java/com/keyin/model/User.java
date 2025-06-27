package com.keyin.model;

import com.keyin.datastructures.TaskList;

public class User {
    private final String name;         // mark as final since it’s only set in the ctor
    private final TaskList taskList;   // ditto

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.add(new Task(description));
    }

    public void markTaskCompleted(int index) {
        taskList.markCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printAll();
    }
}

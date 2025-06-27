package com.keyin.model;
import com.keyin.datastructures.TaskList;
import com.keyin.model.Task;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private TaskList taskList;

    // 2. Constructor (how to build it)
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }
    // 3. Methods (behavior)

    public void setName(String name) {
        this.name = name;
    }

    public void addTask(String description) {
        taskList.add(new Task(description));
    }

    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printAll();
    }
}
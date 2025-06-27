package com.keyin.datastructures;
import com.keyin.model.Task;

public class TaskList {
    private Node head;

    public void printAll() {
        Node curr = head;
        int i = 0;
        while (curr != null) {
            System.out.println(i + ": " + curr.data);
            curr = curr.next;
            i++;
        }
        if (i == 0) {
            System.out.println("  (no tasks yet)");
        }
    }


    private static class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    public TaskList() {
        this.head = null;
    }

    public void add(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void markCompleted(int index) {
        if (index < 0) {
            System.out.println("Invalid index: " + index);
            return;
        }
        Node curr = head;
        int i = 0;
        while (curr != null && i < index) {
            curr = curr.next;
            i++;
        }
        if (curr == null) {
            System.out.println("No task at index " + index);
        } else {
            curr.data.markCompleted();
        }
    }
}

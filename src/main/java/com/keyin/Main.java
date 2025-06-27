package com.keyin;

import com.keyin.model.User;
import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 10;   // or adjust your limit

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[MAX_USERS];
        int userCount = 0;
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== To-Do List Manager ===");
            System.out.println("1. Create user");
            System.out.println("2. Add task to user");
            System.out.println("3. Mark task completed");
            System.out.println("4. View user’s tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    if (userCount >= MAX_USERS) {
                        System.out.println("User limit reached.");
                        break;
                    }
                    System.out.print("Enter username: ");
                    String name = scanner.nextLine();
                    if (findUser(users, userCount, name) != -1) {
                        System.out.println("User already exists.");
                    } else {
                        users[userCount++] = new User(name);
                        System.out.println("Created user: " + name);
                    }
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    name = scanner.nextLine();
                    int idx = findUser(users, userCount, name);
                    if (idx == -1) {
                        System.out.println("No such user.");
                    } else {
                        System.out.print("Enter task description: ");
                        String desc = scanner.nextLine();
                        users[idx].addTask(desc);
                        System.out.println("Added task.");
                    }
                    break;

                case "3":
                    System.out.print("Enter username: ");
                    name = scanner.nextLine();
                    idx = findUser(users, userCount, name);
                    if (idx == -1) {
                        System.out.println("No such user.");
                    } else {
                        users[idx].printTasks();
                        System.out.print("Enter task index to mark completed: ");
                        try {
                            int taskIdx = Integer.parseInt(scanner.nextLine());
                            users[idx].markTaskCompleted(taskIdx);
                            System.out.println("Marked completed.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid index format.");
                        }
                    }
                    break;

                case "4":
                    System.out.print("Enter username: ");
                    name = scanner.nextLine();
                    idx = findUser(users, userCount, name);
                    if (idx == -1) {
                        System.out.println("No such user.");
                    } else {
                        users[idx].printTasks();
                    }
                    break;

                case "5":
                    exit = true;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please choose a valid option.");
            }
        }

        scanner.close();
    }

    // Helper: return index of user in array, or -1 if not found
    private static int findUser(User[] users, int count, String name) {
        for (int i = 0; i < count; i++) {
            if (users[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}

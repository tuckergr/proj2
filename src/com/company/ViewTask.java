package com.company;

import java.util.List;
import java.util.Scanner;

class ViewTask {
    private Scanner scanner = new Scanner(System.in);
    private TaskInput taskInput;

    ViewTask(TaskInput collection) {
        this.taskInput = collection;
    }
    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }catch(NullPointerException e) {
            return false;
        }finally {
            return true;
        }
    }
    private String prompt(String a) {
        System.out.println(a);
        return this.scanner.nextLine();
    }
    private int promptInt(String a) {
        String b = prompt(a);
        boolean isInt = isInteger(b);
        while (!isInt) {
            b = prompt(a);
            isInt = isInteger(b);
        }
        return Integer.parseInt(b);
    }
    private void addTasks() {
        String name = prompt("Enter the tasks name");
        String description = prompt("Enter the tasks description");
        int priority = promptInt("Enter the tasks priority");
        this.taskInput.addTask(name, description, priority);
    }
    private void removeTasks() {
        int index = promptInt("Enter the index of the task to remove.");
        this.taskInput.removeTask(index);
    }
    private void updateTasks() {
        int a = promptInt("Enter the index of the task to update.");
        String rename = prompt("Enter the new name.");
        String newDesc = prompt("Enter the new Description");
        int newPrio = promptInt("Enter the new priority");
        this.taskInput.updateTask(a, rename, newDesc, newPrio);
    }
    private void display(List<Task> tasks) {
        for (int i = 1; i < tasks.size();) {
            Task task = tasks.get(i);
            System.out.println("Task index: " + i +
                                "\nName: " + task.getName() +
                                "\nDescription: " + task.getDesc() +
                                "\nPriority: " + task.getPrio());
        }
    }
    private void listAllTasks() {
        display(this.taskInput.getTasks());
    }
    private void listByPrio() {
        int priority = promptInt("Enter a priority");
        display(this.taskInput.getTasks(priority));
    }
    private void startProg() {
        boolean endLoop = false;
        while (!endLoop) {
            System.out.println("(1) Add a task.\n" +
                                "(2) Remove a task.\n" +
                                "(3) Update a task.\n" +
                                "(4) List all tasks.\n" +
                                "(5) List all tasks by priority.\n" +
                                "(0) Exit.");
            int userInput = promptInt("Choose an option.");
            switch (userInput) {
                case 1:
                    addTasks();
                case 2:
                    removeTasks();
                case 3:
                    updateTasks();
                case 4:
                    listAllTasks();
                case 5:
                    listByPrio();
                case 0:
                    endLoop = true;
            }
        }
    }
    public void run() {
        startProg();
    }
}


package com.company;

public class Main {
    public static void main(String[] args) {
        TaskInput collection = new TaskInput();
        ViewTask view = new ViewTask(collection);
        view.run();
    }
}

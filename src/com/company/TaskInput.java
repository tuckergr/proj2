package com.company;

import java.util.LinkedList;
import java.util.List;

public class TaskInput {
    private List<Task> tasks = new LinkedList<>();

    private Task createNewTask(String name, String desc, int prio) {
        return new Task(name, desc, prio);
    }
    public void addTask(String name, String desc, int prio) {
        this.tasks.add(createNewTask(name, desc, prio));
    }
    public void removeTask(int i) {
        if (this.tasks.size() > i)
            this.tasks.remove(i);
    }
    public void updateTask(int index, String name, String desc, int prio) {
        this.tasks.set(index, createNewTask(name, desc, prio));
    }
    public List<Task> getTasks() {
        return this.tasks;
    }
    public List<Task> getTasks(int prio) {
        List<Task> prioMatch = new LinkedList<>();
        for (Task task : this.tasks) {
            if (task.getPrio() == prio)
                prioMatch.add(task);
        }
        return prioMatch;
    }
}




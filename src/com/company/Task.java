package com.company;
public class Task {
    private String name;
    private String desc;
    private int prio;

    public Task(String name, String desc, int prio) {
        this.name = name;
        this.desc = desc;
        this.prio = prio;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getPrio() {
        return prio;
    }
    public void setPrio(int prio) {
        if (prio < 0) {
            this.prio = 0;
        } else if (prio > 5) {
            this.prio = 5;
        } else {
            this.prio = prio;
        }
    }
}

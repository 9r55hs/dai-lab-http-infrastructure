package ch.heig.dai.lab.api;

import java.util.Date;

public class Task {
    private String name;
    private String description;
    private String dueDate;
    private boolean done;

    public Task() {
    }

    public Task(String name, String description, String dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.done = false;
    }

    //region Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isDone() {
        return done;
    }
    //endregion Getters

    //region Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    //endregion Setters
}

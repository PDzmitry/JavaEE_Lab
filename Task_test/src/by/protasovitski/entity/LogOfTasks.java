package by.protasovitski.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LogOfTasks implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Task task;

    private int timeSpent;

    private String description;

    public LogOfTasks() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LogOfTasks{" +
                "id=" + id +
                ", task=" + task +
                ", timeSpent=" + timeSpent +
                ", description='" + description + '\'' +
                '}';
    }
}

package by.protasovitski.springfirst.entities;

import by.protasovitski.springfirst.entities.enums.TaskType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Task parent;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @Enumerated
    @Column(name = "type")
    private TaskType type;

    @Column(name = "estimate")
    private Double estimate;

    @Transient
    private Double elapsed;

    @Column(name = "opened")
    private LocalDateTime opened;

    @Column(name = "due")
    private LocalDate due;

    @OneToOne(mappedBy = "task", cascade = {CascadeType.ALL},orphanRemoval = true)
    private TaskInfo taskInfo;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.ALL},orphanRemoval = true)
    private List<Task> subtasks;

    @OneToMany(mappedBy = "task" , cascade = {CascadeType.ALL} ,orphanRemoval = true)
    private List<Activity> activities;

    @Transient
    private Activity lastActivity;

    public Task(Project project, Task parent, User creator, TaskType type, Double estimate, Double elapsed, LocalDateTime opened, LocalDate due, TaskInfo taskInfo, List<Task> subtasks, List<Activity> activities) {
        this.project = project;
        this.parent = parent;
        this.creator = creator;
        this.type = type;
        this.estimate = estimate;
        this.elapsed = elapsed;
        this.opened = opened;
        this.due = due;
        this.taskInfo = taskInfo;
        this.subtasks = subtasks;
        this.activities = activities;
    }
}

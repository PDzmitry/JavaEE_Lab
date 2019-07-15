package by.protasovitski.springfirst.entities;

import by.protasovitski.springfirst.entities.enums.TaskStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @Enumerated
    @Column(name = "status")
    private TaskStatus status;

    @Column(name = "elapsed")
    private Double elapsed;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "description")
    private String description;

    public Activity(Task task, User creator, User assignee, TaskStatus status, Double elapsed, LocalDateTime timestamp, String description) {
        this.task = task;
        this.creator = creator;
        this.assignee = assignee;
        this.status = status;
        this.elapsed = elapsed;
        this.timestamp = timestamp;
        this.description = description;
    }
}

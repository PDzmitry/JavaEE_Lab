package by.protasovitski.springfirst.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "task_info")
public class TaskInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public TaskInfo(Task task, String name, String description) {
        this.task = task;
        this.name = name;
        this.description = description;
    }
}



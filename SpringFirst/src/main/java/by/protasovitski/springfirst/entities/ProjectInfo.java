package by.protasovitski.springfirst.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "projet_info")
public class ProjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "about")
    private String about;

    public ProjectInfo(Project project, String name, String description, String about) {
        this.project = project;
        this.name = name;
        this.description = description;
        this.about = about;
    }
}

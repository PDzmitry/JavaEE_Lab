package by.protasovitski.springfirst.entities;

import by.protasovitski.springfirst.entities.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Project project;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated
    @Column(name = "role")
    private UserRole role;

    public Role(Project project, User user, UserRole role) {
        this.project = project;
        this.user = user;
        this.role = role;
    }
}

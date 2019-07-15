package by.protasovitski.springfirst.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_credentials")
public class UserCredentials {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "login")
    private String login;

    @Column(name = "hash")
    private String hash;

    public UserCredentials(User user, String login, String hash) {
        this.user = user;
        this.login = login;
        this.hash = hash;
    }
}

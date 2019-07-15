package by.protasovitski.springfirst.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
@Data
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "bio")
    private String bio;

    @Column(name = "url")
    private String url;

    @Column(name = "company")
    private String company;

    @Column(name = "location")
    private String location;

    public UserInfo(User user) {
        this.user = user;
    }
}

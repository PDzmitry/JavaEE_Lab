package by.protasovitski.springfirst.entities.nontable;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProjectActivity {
    LocalDate getDay();

    Integer getActivityAmount();
}

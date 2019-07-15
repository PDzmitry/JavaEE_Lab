package by.protasovitski.springfirst.entities.nontable;

import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskType {
    Integer getType();

    Integer getCount();
}

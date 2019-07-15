package by.protasovitski.springfirst.repository;

import by.protasovitski.springfirst.entities.Project;
import by.protasovitski.springfirst.entities.Role;
import by.protasovitski.springfirst.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
    Optional<Role> findByUserAndProject(User user, Project project);
}

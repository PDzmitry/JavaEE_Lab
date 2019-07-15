package by.protasovitski.springfirst.repository;

import by.protasovitski.springfirst.entities.UserCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials,Long> {
    Optional<UserCredentials> findByLogin(String login);
}

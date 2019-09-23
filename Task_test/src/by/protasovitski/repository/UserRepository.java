package by.protasovitski.repository;

import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends Repository<User,Long> {
    Optional<User> findByLoginAndPassword(String login,byte[] password) throws RepositoryException;
    Map<User,Long> findAllWithCountTasks() throws RepositoryException;
    List<User> findAllHaveTasksWithTotalTimeMore(Long totalTime) throws RepositoryException;
}

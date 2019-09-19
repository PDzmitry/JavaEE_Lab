package by.protasovitski.repository;

import by.protasovitski.entity.Task;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends Repository<Task,Long> {
    List<Task> findAllByUserId(Long userId) throws RepositoryException;
}

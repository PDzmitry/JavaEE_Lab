package by.protasovitski.repository;

import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.exception.RepositoryException;

import java.util.List;

public interface LogOfTaskRepository extends Repository<LogOfTasks,Long> {
    List<LogOfTasks> findAllByTaskId(Long taskId) throws RepositoryException;
}

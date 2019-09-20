package by.protasovitski.service;

import by.protasovitski.entity.LogOfTasks;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface LogOfTaskService  extends Serializable {
    List<LogOfTasks> findAllByTaskId(Long taskId);
    Optional<LogOfTasks> save(LogOfTasks log);
    Optional<LogOfTasks> findById(Long id);
}

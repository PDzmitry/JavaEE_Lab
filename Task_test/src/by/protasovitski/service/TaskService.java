package by.protasovitski.service;

import by.protasovitski.entity.Task;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface TaskService extends Serializable {
    List<Task> findAllByUserId(Long userId);
    Optional<Task> save(Task task);
    Optional<Task> findById(Long id);
}

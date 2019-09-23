package by.protasovitski.service;

import by.protasovitski.entity.User;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService extends Serializable {
    Optional<User> save(User user);
    void remove(Long id);
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> login(String login,byte[] password);
    Map<User,Long> findAllWithCountTasks();
    List<User> findAllHaveTasksWithTotalTimeMore(Long totalTime);
}

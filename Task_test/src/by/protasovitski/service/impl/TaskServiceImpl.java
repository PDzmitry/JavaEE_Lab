package by.protasovitski.service.impl;

import by.protasovitski.entity.Task;
import by.protasovitski.repository.TaskRepository;
import by.protasovitski.service.TaskService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class TaskServiceImpl implements TaskService {
    @Inject
    private TaskRepository taskRepository;


    @Override
    public List<Task> findAllByUserId(Long userId) {
        try{
            return taskRepository.findAllByUserId(userId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Task> save(Task task) {
        try {
            return Optional.of(taskRepository.save(task));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Task> findById(Long id) {
        try{
            return taskRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

package by.protasovitski.service.impl;

import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.repository.LogOfTaskRepository;
import by.protasovitski.service.LogOfTaskService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;


@Named
@RequestScoped
public class LogOfTaskServiceImpl implements LogOfTaskService {

    @Inject
    private LogOfTaskRepository logOfTaskRepository;

    @Override
    public List<LogOfTasks> findAllByTaskId(Long taskId) {
        try{
            return logOfTaskRepository.findAllByTaskId(taskId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<LogOfTasks> save(LogOfTasks log) {
        try {
            return Optional.of(logOfTaskRepository.save(log));
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<LogOfTasks> findById(Long id) {
        try{
            return logOfTaskRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

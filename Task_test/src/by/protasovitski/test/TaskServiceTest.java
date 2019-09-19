package by.protasovitski.test;

import by.protasovitski.entity.Task;
import by.protasovitski.entity.User;
import by.protasovitski.repository.impl.TaskRepositoryImpl;
import by.protasovitski.service.TaskService;
import by.protasovitski.service.impl.TaskServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

public class TaskServiceTest {
    @Inject
    private TaskService taskService;


    @Test
    public void testFindAllRecords() {
        Long userId = 1L;
        List<Task> tasks = taskService.findAllByUserId(userId);
        if (!tasks.isEmpty()){
            for (Task task : tasks) {
                System.out.println(task.toString());
            }
        }
    }
}

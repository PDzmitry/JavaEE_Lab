package by.protasovitski.command.grouplogoftasks;

import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.factory.Type;
import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.entity.Task;
import by.protasovitski.entity.User;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.LogOfTaskService;
import by.protasovitski.service.TaskService;
import by.protasovitski.service.UserService;
import by.protasovitski.util.pages.Page;
import org.hibernate.internal.util.StringHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.protasovitski.command.groupusers.constant.GroupConstant.*;
import static by.protasovitski.command.groupusers.constant.GroupConstant.LISTGROUP;
import static by.protasovitski.command.session.SessionAttribute.USER;
import static java.util.Optional.of;

@RequestScoped
@Type(CommandType.ADD_NEW_LOG)
public class AddNewLogCommand implements Command {
    @Inject
    private TaskService taskService;
    @Inject
    private LogOfTaskService logOfTaskService;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, ServletException, IOException {
        Optional<String> id = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(TASK_ID));
        Optional<String> description = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(LOG_DESCRIPTION));
        Optional<String> timeSpent = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(TIME_SPENT));
        if (StringHelper.isEmpty(description.get()) || StringHelper.isEmpty(timeSpent.get()) || StringHelper.isEmpty(description.get())) {
//            LOGGER.info("missing parameter for new person in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {

            Long id_task = Long.parseLong(id.get());
            Integer time = Integer.parseInt(timeSpent.get());

            Optional<Task> task = taskService.findById(id_task);
            if (task.isPresent()) {
                LogOfTasks log = new LogOfTasks();
                log.setDescription(description.get());
                log.setTimeSpent(time);
                log.setTask(task.get());
                logOfTaskService.save(log);
            }

        }
        Long userId = ((User) request.getSession().getAttribute(USER)).getId();
        List<Task> tasks = taskService.findAllByUserId(userId);
        if (!tasks.isEmpty()) {
            request.setAttribute(LISTGROUP, tasks);
        }
        return new CommandResult(Page.WELCOME_PAGE.getValue(), false);
    }
}

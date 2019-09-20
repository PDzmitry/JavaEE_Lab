package by.protasovitski.command.grouptasks;

import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.Task;
import by.protasovitski.entity.User;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.TaskService;
import by.protasovitski.service.UserService;
import by.protasovitski.util.pages.Page;
import org.hibernate.internal.util.StringHelper;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.protasovitski.command.session.SessionAttribute.USER;
import static by.protasovitski.command.session.SessionAttribute.USER_ID;
import static by.protasovitski.command.groupusers.constant.GroupConstant.*;
import static java.util.Optional.of;

//import org.apache.commons.lang3.StringUtils;

@RequestScoped
@Type(CommandType.ADD_NEW_TASK)
public class AddNewTaskCommand implements Command {

    @Inject
    private TaskService taskService;
    @Inject
    private UserService userService;
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException,  ServletException, IOException {
        Long userId = ((User) request.getSession().getAttribute(USER)).getId();
        Optional<String> newNameTask = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEW_NAME_TASK));
        if (StringHelper.isEmpty(newNameTask.get())) {
//            LOGGER.info("missing parameter for new person in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {

            Optional<User> user = userService.findById(userId);
            if (user.isPresent()) {
                Task task = new Task();
                task.setNameTask(newNameTask.get());
                task.setStatus(false);
                task.setUser(user.get());
                taskService.save(task);
            }

        }
        List<Task> tasks = taskService.findAllByUserId(userId);
        if (!tasks.isEmpty()) {
            request.setAttribute(LISTGROUP, tasks);
        }
        return new CommandResult(Page.WELCOME_PAGE.getValue(), false);
    }
}

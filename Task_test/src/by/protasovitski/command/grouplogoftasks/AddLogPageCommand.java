package by.protasovitski.command.grouplogoftasks;

import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.groupusers.constant.UrlConstant;
import by.protasovitski.entity.LogOfTasks;
import by.protasovitski.entity.Task;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.TaskService;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.protasovitski.command.authorithation.AuthConstants.REGISTER_ERROR;
import static by.protasovitski.command.authorithation.AuthConstants.REGISTER_ERROR_MESSAGE_IF_EXIST;
import static by.protasovitski.command.groupusers.constant.GroupConstant.*;
import static java.util.Optional.of;

@RequestScoped
@Type(CommandType.ADD_LOG_PAGE)
public class AddLogPageCommand implements Command {
    @Inject
    private TaskService taskService;

    private CommandResult forwardToWelcomeWithError(HttpServletRequest request,
                                                    String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(UrlConstant.COMMAND_WELCOME, true);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        Optional<String> id = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(TASK_ID));
        if (id.isPresent()){
            Long id_task=Long.parseLong(id.get());
            Optional<Task> task = taskService.findById(id_task);
            if (task.isPresent()){
                request.setAttribute(TASK,task.get());
                return new CommandResult(Page.ADD_LOG_PAGE.getValue(),false);
            }
        }
        return  forwardToWelcomeWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
    }
}

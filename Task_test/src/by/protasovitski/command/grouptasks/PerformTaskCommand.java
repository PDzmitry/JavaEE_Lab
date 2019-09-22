package by.protasovitski.command.grouptasks;

import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.Task;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.command.groupusers.constant.UrlConstant;
import by.protasovitski.service.TaskService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static by.protasovitski.command.authorithation.AuthConstants.REGISTER_ERROR;
import static by.protasovitski.command.authorithation.AuthConstants.REGISTER_ERROR_MESSAGE_IF_EXIST;
import static by.protasovitski.command.groupusers.constant.GroupConstant.TASK_ID;
import static java.util.Optional.of;

@RequestScoped
@Type(CommandType.PERFORM_TASK)
public class PerformTaskCommand implements by.protasovitski.command.Command {

    @Inject
    private TaskService taskService;

    private CommandResult forwardToWelcomeWithError(HttpServletRequest request,
                                                    String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(UrlConstant.COMMAND_WELCOME, false);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        System.out.println("PERFORM_TASK");
        Optional<String> id = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(TASK_ID));
        if (id.isPresent()){
            Optional<Task> task = taskService.findById(Long.parseLong(id.get()));
            if (task.isPresent()){
                task.get().setStatus(true);
                if(taskService.save(task.get()).isPresent()){
                   return new CommandResult(UrlConstant.COMMAND_WELCOME, false);

                }else{
                    return  forwardToWelcomeWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
                }


            }else{
                return  forwardToWelcomeWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
            }
        }else{
            return  forwardToWelcomeWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
        }
    }
}

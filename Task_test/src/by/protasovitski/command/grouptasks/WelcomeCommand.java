package by.protasovitski.command.grouptasks;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.Task;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.TaskService;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.protasovitski.command.session.SessionAttribute.USER_ID;
import static by.protasovitski.command.groupusers.constant.GroupConstant.LISTGROUP;

@SessionScoped
@Type(CommandType.WELCOME)
public class WelcomeCommand implements Command {

    @Inject
    private TaskService taskService;

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
//        UserService userService = new UserServiceImpl(new UserRepositoryImpl());
//        TaskService taskService = new TaskServiceImpl(new TaskRepositoryImpl());
//        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        Long userId = Long.parseLong((String) request.getSession().getAttribute(USER_ID)) ;
        List<Task> tasks = taskService.findAllByUserId(userId);
        if (!tasks.isEmpty()){
            request.setAttribute(LISTGROUP,tasks);
        }
        return new CommandResult(Page.WELCOME_PAGE.getValue(),false);
    }
}

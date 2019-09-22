package by.protasovitski.command.groupusers;

import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.factory.Type;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.UserService;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.protasovitski.command.groupusers.constant.GroupConstant.LISTGROUP;
import static by.protasovitski.command.groupusers.constant.GroupConstant.TOTAL;
import static java.util.Optional.of;

@RequestScoped
@Type(CommandType.LIST_USERS_WITH_TASK_COMPLETION)
public class ListUsersWithTaskCompletion implements Command {
    @Inject
    private UserService userService;
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        Optional<String> total = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(TOTAL));
        if (total.isPresent()){
            List<User> users = userService.findAllHaveTasksWithTotalTimeMore(Long.parseLong(total.get()));
            if (!users.isEmpty()){
                request.setAttribute(LISTGROUP,users);
            }
        }

        return new CommandResult(Page.LIST_USERS_WITH_TASK_COMPLETION.getValue(),false);
    }
}

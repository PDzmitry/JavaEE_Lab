package by.protasovitski.command.groupusers;

import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.UserService;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static by.protasovitski.command.authorithation.AuthConstants.*;
import static by.protasovitski.command.groupusers.constant.GroupConstant.LISTGROUP;
import static java.util.Optional.of;

@RequestScoped
@Type(CommandType.EDIT_USER_PAGE)
public class EditUserPageCommand implements by.protasovitski.command.Command {
    @Inject
    private UserService userService;

    private CommandResult forwardToListUsersWithError(HttpServletRequest request,
                                                      String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        List<User> users = userService.findAll();
        if (!users.isEmpty()){
            request.setAttribute(LISTGROUP,users);
        }
        return new CommandResult(Page.LIST_USERS_PAGE.getValue(), false);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        System.out.println("EDIT_USER_PAGE");
        Optional<String> id = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(USER_ID));
        if (id.isPresent()){
            Optional<User> user = userService.findById(Long.parseLong(id.get()));
            if (user.isPresent()){
                request.setAttribute(USER,user.get());
                return new CommandResult(Page.EDIT_USER_PAGE.getValue(),false);
            }else{
                return  forwardToListUsersWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
            }
        }else{
            return  forwardToListUsersWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
        }

    }
}

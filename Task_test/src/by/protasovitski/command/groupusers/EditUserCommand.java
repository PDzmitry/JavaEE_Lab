package by.protasovitski.command.groupusers;

import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.command.groupusers.constant.UrlConstant;
import by.protasovitski.service.UserService;
import by.protasovitski.util.HashPasswordImpl;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static by.protasovitski.command.authorithation.AuthConstants.*;
import static java.util.Optional.of;
import static org.hibernate.internal.util.StringHelper.isEmpty;


@RequestScoped
@Type(CommandType.EDIT_USER)
public class EditUserCommand implements by.protasovitski.command.Command {
    @Inject
    private UserService userService;

    @Inject
    private HashPasswordImpl hashPassword;

    private CommandResult forwardToEditWithError(HttpServletRequest request,
                                                 String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);

        return new CommandResult(Page.EDIT_USER_PAGE.getValue(), false);
    }

    private CommandResult forwardToListUsers(HttpServletRequest request) {

        return new CommandResult(UrlConstant.COMMAND_LIST_USERS, false);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        Optional<String> id = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(USER_ID));
        Optional<String> name = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(NAME_FOR_REGISTER));
        Optional<String> login = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(LOGIN_FOR_REGISTER));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD_FOR_REGISTER));

        if (isEmpty(login.get()) || isEmpty(password.get()) || isEmpty(name.get()) || isEmpty(id.get())) {
//            LOGGER.info("invalid name, login or password format was received:" + name + login +
//                    " " + password);
            return forwardToEditWithError(request, REGISTER_ERROR, ERROR_MESSAGE_TEXT);
        }
        byte[] pass = hashPassword.getHash(password.get());
//        UserService userService = new UserServiceImpl(new UserRepositoryImpl());
        Optional<User> user = userService.findById(Long.parseLong(id.get()));
        if (user.isPresent()) {
            user.get().setLogin(login.get());
            user.get().setName(name.get());
            user.get().setPassword(pass);
            if (userService.save(user.get()).isPresent()) {
                return forwardToListUsers(request);
            } else {
                return forwardToEditWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
            }

        }else{
            return forwardToEditWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
        }

    }
}

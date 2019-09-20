package by.protasovitski.command.groupusers;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
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
@Type(CommandType.REGISTER_NEW_USER)
public class RegisterNewUserCommand implements Command {
//    private static final Logger LOGGER = Logger.getLogger(RegisterNewUserCommand.class.getName());
    @Inject
    private UserService userService;

    @Inject
    private HashPasswordImpl hashPassword;

    private CommandResult forwardToRegisterWithError(HttpServletRequest request,
                                                     String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.REGISTER_PAGE.getValue(), false);
    }

    private CommandResult forwardToLogin(HttpServletRequest request) {
        return new CommandResult(Page.LOGIN_PAGE.getValue(), false);
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        Optional<String> name = of(request).
                map(httpServletRequest ->
                        httpServletRequest.getParameter(NAME_FOR_REGISTER));
        Optional<String> login = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(LOGIN_FOR_REGISTER));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD_FOR_REGISTER));
        if (isEmpty(login.get()) || isEmpty(password.get()) || isEmpty(name.get())) {
//            LOGGER.info("invalid name, login or password format was received:" + name + login +
//                    " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR, ERROR_MESSAGE_TEXT);
        }
        byte[] pass = hashPassword.getHash(password.get());
        User user = new User(name.get(), login.get(), pass);
//        UserService userService = new UserServiceImpl(new UserRepositoryImpl());

        if (userService.save(user).isPresent()) {
//            LOGGER.info("user was registered: name:" + name + "login:" + login + " password:" +
//                    password);
            return forwardToLogin(request);
        } else {
//            LOGGER.info("invalid name, login or password format was received:" + login +
//                    " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR, REGISTER_ERROR_MESSAGE_IF_EXIST);
        }
    }
}

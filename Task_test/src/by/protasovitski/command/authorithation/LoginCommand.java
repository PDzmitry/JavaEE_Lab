package by.protasovitski.command.authorithation;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.session.SessionAttribute;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.service.UserService;
import by.protasovitski.util.HashPasswordImpl;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static by.protasovitski.command.authorithation.AuthConstants.*;
import static java.util.Optional.of;
import static org.hibernate.internal.util.StringHelper.isEmpty;

@RequestScoped
@Type(CommandType.LOGIN)
public class LoginCommand implements Command {
//    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());
    @Inject
    private UserService userService;

    @Inject
    private HashPasswordImpl hashPassword;


    private void setAttributesToSession(User user, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.USER,user);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        boolean isUserFind=false;
        Optional<String> login = of(request)
                .map(httpServletRequest->
                        httpServletRequest.getParameter(LOGIN));
        Optional<String> password = of(request)
                .map(httpServletRequest->
                        httpServletRequest.getParameter(PASSWORD));
        if (isEmpty(login.get())||isEmpty(password.get())){
            return forwardLoginWithError(request,ERROR_MESSAGE,ERROR_MESSAGE_TEXT);
        }
        byte[] pass = hashPassword.getHash(password.get());
        isUserFind = initializeUserIfExist(login.get(),pass,request);
        if (!isUserFind){
//            LOGGER.info("user with such login and password doesn't exist");
            return forwardLoginWithError(request,ERROR_MESSAGE,AUTHENTICATION_ERROR_TEXT);
        }else{
//            LOGGER.info("user has been authorized: login:" + login + " password:"+
//                    password);
            return new CommandResult(COMMAND_WELCOME,false);
        }
    }

    public boolean initializeUserIfExist(String login, byte[] password, HttpServletRequest request) throws ServiceException {
        Optional<User> user = userService.login(login,password);
        boolean userExist = false;
        if (user.isPresent()){
            setAttributesToSession(user.get(),request);
            userExist=true;
        }
        return userExist;
    }
    private CommandResult forwardLoginWithError(HttpServletRequest request, final String ERROR,
                                                final String ERROR_MESSAGE){
        request.setAttribute(ERROR,ERROR_MESSAGE);
        return new CommandResult(Page.LOGIN_PAGE.getValue(),false);
    }
}

package by.protasovitski.command.authorithation;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.session.SessionAttribute;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@SessionScoped
@Type(CommandType.SIGN_OUT)
public class SingOutCommand implements Command {
//    private static final Logger LOGGER = Logger.getLogger(SingOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute(SessionAttribute.USER_ID);
//        LOGGER.info("user was above: name:"+name);
        session.removeAttribute(SessionAttribute.USER_ID);
        return new CommandResult(Page.LOGIN_PAGE.getValue(),false);
    }
}

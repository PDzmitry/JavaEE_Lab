package by.protasovitski.command.authorithation;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.session.SessionAttribute;
import by.protasovitski.entity.User;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.util.pages.Page;
import org.apache.log4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestScoped
@Type(CommandType.SIGN_OUT)
public class SingOutCommand implements Command {
//    private static final Logger LOGGER = Logger.getLogger(SingOutCommand.class.getName());

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SessionAttribute.USER);
//        LOGGER.info("user was above: name:"+user.getLogin());
        session.removeAttribute(SessionAttribute.USER);
        return new CommandResult(Page.LOGIN_PAGE.getValue(),false);
    }
}

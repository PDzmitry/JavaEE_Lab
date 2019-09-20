package by.protasovitski.command.groupusers;



import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.Type;
import by.protasovitski.command.factory.CommandType;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.util.pages.Page;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestScoped
@Type(CommandType.REGISTRATION_PAGE)
public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, RepositoryException, ServletException, IOException {
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getValue(),false);
    }
}

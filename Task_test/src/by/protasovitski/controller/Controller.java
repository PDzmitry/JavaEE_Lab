package by.protasovitski.controller;


import by.protasovitski.command.Command;
import by.protasovitski.command.CommandResult;
import by.protasovitski.command.factory.CommandFactory;
import by.protasovitski.command.groupusers.constant.UrlConstant;
import by.protasovitski.exception.RepositoryException;
import by.protasovitski.exception.ServiceException;
import by.protasovitski.util.pages.Page;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = UrlConstant.URL_CONTROLLER, name = "DispatcherServlet")
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";
    private static final String ERROR_MESSAGE = "error_message";
//    private static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    @Inject
    private CommandFactory commandFactory;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter(COMMAND);
//        LOGGER.info(COMMAND+ "=" + command);
        Command action = commandFactory.create(command);

        CommandResult commandResult;
        try {
            commandResult = action.execute(request, response);
        } catch (ServiceException | RepositoryException e) {
//          LOGGER.error(e.getMessage(),e);
            request.setAttribute(ERROR_MESSAGE, e.getMessage());
            commandResult = new CommandResult(Page.ERROR_PAGE.getValue(), false);
        }
        String page = commandResult.getPage();
        if (commandResult.isRedirect()) {
            sendRedirect(response, page);
        } else {
            dispatch(request, response, page);
        }
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
        requestDispatcher.forward(request, response);
    }

    private void sendRedirect(HttpServletResponse response, String page) throws IOException {
        response.sendRedirect(page);
    }
}

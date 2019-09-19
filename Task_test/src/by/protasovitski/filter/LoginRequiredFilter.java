package by.protasovitski.filter;


import by.protasovitski.command.session.SessionAttribute;
import by.protasovitski.util.pages.Page;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller")
public class LoginRequiredFilter implements Filter {
    private static final String COMMAND = "command";
    private static final String WELCOME = "welcome";
    private static final String ERROR_MESSAGE = "error_message";
    private static final String ERROR_TEXT = "Нет авторизации для выполнения данной команды";
//    private static final Logger LOGGER = Logger.getLogger(LoginRequiredFilter.class.getName());

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String command = request.getParameter(COMMAND);
//        LOGGER.info("Filter is working " + COMMAND + "= " + command);
        if (!command.equals(WELCOME)) {
            chain.doFilter(req, resp);
        } else {
            if (request.getSession().getAttribute(SessionAttribute.USER_ID)!=null){
                chain.doFilter(req,resp);
            }else{
                request.setAttribute(ERROR_MESSAGE,ERROR_TEXT);
                request.getRequestDispatcher(Page.ERROR_PAGE.getValue()).forward(req,resp);
            }

        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

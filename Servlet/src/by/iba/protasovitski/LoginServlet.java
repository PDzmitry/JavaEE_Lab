package by.iba.protasovitski;

import by.iba.protasovitski.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(urlPatterns = "/LoginServlet", name = "LoginServlet")
public class LoginServlet extends HttpServlet {

    /*public boolean checkLogin(String name,String password){
        return (name.equalsIgnoreCase("admin")&&
                password.equalsIgnoreCase("admin"));
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");

        UserDao daoUser = new UserDao();

        if (daoUser.isValidUser(name, password)) {
            request.getSession().setAttribute("name", name);
            Cookie cookie = new Cookie(name, (new SimpleDateFormat("hh:mm:ss")).format(new Date()));
            cookie.setMaxAge(3600);
            response.addCookie(cookie);
            request.getRequestDispatcher("/GroupServlet")
                    .forward(request, response);
        } else {
            request.setAttribute("error", "Ivalid password and/or login");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }
}

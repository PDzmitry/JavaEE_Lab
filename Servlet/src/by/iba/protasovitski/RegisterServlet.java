package by.iba.protasovitski;

import by.iba.protasovitski.dao.UserDao;
import by.iba.protasovitski.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet", name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String password = request.getParameter("password").trim();

        UserDao daoUser = new UserDao();

        if (!daoUser.hasUser(name)) {
            if (("".equals(name)) || ("".equals(password))) {
                request.setAttribute("error", "Заполните все поля");
            } else {
                if (name != null && password != null)
                    if (daoUser.create(new User(name, daoUser.crypt(password)))) {
                        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                                .forward(request, response);
                    } else {
                        request.setAttribute("error", "Пользователь не создан");
                        request.getRequestDispatcher("/WEB-INF/views/registry.jsp")
                                .forward(request, response);
                    }
            }


        } else {
            request.setAttribute("error", "Пользователь с таким именем уже есть");
            request.getRequestDispatcher("/WEB-INF/views/registry.jsp")
                    .forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/registry.jsp")
                .forward(request, response);


    }
}

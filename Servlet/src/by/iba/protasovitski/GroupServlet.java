package by.iba.protasovitski;

import by.iba.protasovitski.dao.PersonDao;
import by.iba.protasovitski.model.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import java.io.IOException;

@WebServlet(urlPatterns = "/GroupServlet", name = "GroupServlet")
public class GroupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String getLastTimeEnter(HttpServletRequest request) {
        String time = null;
        String cookieName = request.getParameter("name");
        if (cookieName != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookieName.equals(cookie.getName())) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return time;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nname = request.getParameter("nname");
        String nphone = request.getParameter("nphone");
        String nemail = request.getParameter("nemail");
        String id = request.getParameter("id");
        if (id == null) {
            if (("".equals(nname)) || ("".equals(nphone)) || ("".equals(nemail))) {
                request.setAttribute("error", "Заполните все поля");
            } else {
                if (nname != null && nphone != null && nemail != null)
                    PersonDao.create(new Person(nname, nphone, nemail));
            }
        } else {
            Person person = PersonDao.find(Integer.parseInt(id));
            person.setName(nname);
            person.setPhone(nphone);
            person.setEmail(nemail);
            PersonDao.update(person);
        }

        request.setAttribute("time", getLastTimeEnter(request));
        request.setAttribute("group", PersonDao.findAll());
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            request.setAttribute("group", PersonDao.findAll());
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                    .forward(request, response);
        } else {
            int id = Integer.parseInt(request.getParameter("id"));
            if (action.equalsIgnoreCase("delete")) {
                PersonDao.delete(id);
                request.setAttribute("group", PersonDao.findAll());
                request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                        .forward(request, response);
            } else if (action.equalsIgnoreCase("edit")) {
                Person person = PersonDao.find(id);
                request.setAttribute("person", person);
                request.getRequestDispatcher("/WEB-INF/views/editPerson.jsp")
                        .forward(request, response);
            }
        }
    }
}

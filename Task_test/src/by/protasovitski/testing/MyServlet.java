package by.protasovitski.testing;

import by.protasovitski.command.Command;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/miservlet")
public class MyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private AppDetailBean appDetailBean;
    @Inject
    private LoginController loginController;


    //	private EntityManagerProducer entityManagerProducer;

    private Command command;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /* I know it's old-school! Apologies :) */
        response.setContentType("text/html");
//		EntityManager em= entityManagerProducer.create();
       /* try {
            command.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>App Detail</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>App Name:" + appDetailBean.getAppName() + "</h1>");
        out.println("<h2>Version:" + appDetailBean.getVersion() + "</h2>");
        out.println("<h2>Password:" + loginController.doLogin() + "</h2>");
        out.println("</body>");
        out.println("</html>");

    }

}

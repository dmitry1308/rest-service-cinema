package ru.schepin.restService.servlet.autorization;

import ru.schepin.restService.dao.Dao;
import ru.schepin.restService.dao.UserDao;
import ru.schepin.restService.model.User;
import ru.schepin.restService.util.Urls;
import ru.schepin.restService.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    private Dao<User, String> userDao;
    private boolean isRegistrated = false;

    @Override
    public void init() throws ServletException {
        Object userDao = getServletContext().getAttribute("userDao");
        if (!(userDao instanceof UserDao)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.userDao = (Dao<User, String>) userDao;
        }

        System.out.println("*************SERVLET AddUserServlet  IS INIT************");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы addUser)");
        if (isRegistrated) {
            req.getRequestDispatcher(Urls.choiceCinemas).forward(req, resp);
        } else {
            req.getRequestDispatcher(Urls.addUser).forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        if (!Utils.requestIsValid(req)) {
            doGet(req, resp);
        } else {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = new User(login, password);

            userDao.save(user);
            isRegistrated = true;
            doGet(req, resp);
        }
    }


    @Override
    public void destroy() {
        System.out.println("*************SERVLET AddUserServlet IS DESTROY************");
    }
}

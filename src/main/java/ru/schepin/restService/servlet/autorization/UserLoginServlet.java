package ru.schepin.restService.servlet.autorization;

import ru.schepin.restService.dao.UserDao;
import ru.schepin.restService.dao.UserDaoImpl;
import ru.schepin.restService.model.User;
import ru.schepin.restService.util.Urls;
import ru.schepin.restService.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserLoginServlet extends HttpServlet {
    private UserDao<User, Integer, String> userDao;
    private boolean isRegistrated = false;

    @Override
    public void init() throws ServletException {
        Object userDao = getServletContext().getAttribute("userDao");
        if (!(userDao instanceof UserDaoImpl)) {

            throw new IllegalStateException("You're repo does not initialize!");
        } else {
            this.userDao = (UserDao<User, Integer,String>) userDao;
        }

        System.out.println("*************SERVLET UserLoginServlet  IS INIT************");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы addUser)");
        if (isRegistrated) {
            req.getRequestDispatcher(Urls.choiceCinemas).forward(req, resp);
        } else {
            req.getRequestDispatcher(Urls.userLogin).forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        List<User> allUser = userDao.getByAllUser();
        System.out.println(allUser);

        if (allUser.isEmpty() || (!Utils.requestIsValid(req))) {
            doGet(req, resp);

        } else {
            if (isFindUser(allUser, login,password)) {
                isRegistrated = true;
                doGet(req, resp);
            } else {
                doGet(req, resp);
            }
        }
    }

    private boolean isFindUser(List<User> allUser, String password, String login) {
        for (User anAllUser : allUser) {
            if (anAllUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void destroy() {
        System.out.println("*************SERVLET AddUserServlet IS DESTROY************");
    }
}

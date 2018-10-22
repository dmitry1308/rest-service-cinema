package ru.schepin.restService.servlet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.restService.dao.Dao;
import ru.schepin.restService.dao.UserDao;
import ru.schepin.restService.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetIndexPageServlet extends HttpServlet {
    private SessionFactory sessionFactory;
    private Dao<User, String> userDao;

    private final static String index = "/WEB-INF/view/index.jsp";

    @Override
    public void init() throws ServletException {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        userDao = new UserDao(sessionFactory);


        System.out.println("*************SERVLET IS INIT************");
        System.out.println("FOR PATH '/' WILL RENDER VIEW : " + index);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet is work!(Рендеринг страницы)");
        req.getRequestDispatcher(index).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        } else {
            String login = req.getParameter("login");
            String password = req.getParameter("password");

            User user = new User(login, password);

            userDao.save(user);
            doGet(req, resp);
        }
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        return login != null && login.length() > 0 &&
                password != null && password.length() > 0;
    }

    @Override
    public void destroy() {
        sessionFactory.close();
        // TODO: 21.10.2018 Сюда потом запишу закрытие ресурса фабрики или в другой сервлет
        System.out.println("*************SERVLET IS DESTROY************");
    }
}

package ru.schepin.restService.servlet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.restService.dao.RowInHallDao;
import ru.schepin.restService.dao.RowInHallDaoImpl;
import ru.schepin.restService.dao.UserDao;
import ru.schepin.restService.dao.UserDaoImpl;
import ru.schepin.restService.model.RowInHall;
import ru.schepin.restService.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private SessionFactory sessionFactory;
    private UserDao<User, Integer,String> userDao;
    private RowInHallDao<RowInHall,Integer> rowInHallDao;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        sessionFactory = new Configuration().configure().buildSessionFactory();

        userDao = new UserDaoImpl(sessionFactory);
        rowInHallDao = new RowInHallDaoImpl(sessionFactory);

        servletContext.setAttribute("userDao", userDao);
        servletContext.setAttribute("rowInHallDao", rowInHallDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sessionFactory.close();
        System.out.println("ContextListener is destroyed(factory is closed)");
    }
}
package ru.schepin.restService.servlet;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.schepin.restService.dao.Dao;
import ru.schepin.restService.dao.UserDao;
import ru.schepin.restService.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private SessionFactory sessionFactory;
    private Dao<User, String> userDao;


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        sessionFactory = new Configuration().configure().buildSessionFactory();
        userDao = new UserDao(sessionFactory);
        servletContext.setAttribute("userDao",userDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sessionFactory.close();
        System.out.println("ContextListener is destroyed(factory is closed)");
    }
}
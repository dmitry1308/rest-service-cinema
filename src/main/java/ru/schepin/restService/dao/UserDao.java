package ru.schepin.restService.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.restService.model.User;

public class UserDao implements Dao<User,String>{

    private SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public User getByKey(String s) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

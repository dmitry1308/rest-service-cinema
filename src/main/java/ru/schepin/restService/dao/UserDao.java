package ru.schepin.restService.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.restService.model.User;

import java.util.List;

public class UserDao implements Dao<User,Integer>{

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
    public User getByKey(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return  session.get(User.class, id);
        }
    }

    @Override
    public List<User> getByAllUser() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            List<User> list = criteria.list();
            return list;
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

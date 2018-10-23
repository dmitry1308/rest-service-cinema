package ru.schepin.restService.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.restService.model.User;

import java.util.List;

public class UserDaoImpl implements UserDao<User,Integer> {

    private SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
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

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getByAllUser() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(User.class);
            return (List<User>) criteria.list();
        }
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}

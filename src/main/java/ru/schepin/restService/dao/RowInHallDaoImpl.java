package ru.schepin.restService.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.schepin.restService.model.RowInHall;

import java.util.List;

public class RowInHallDaoImpl implements RowInHallDao<RowInHall> {
    private SessionFactory sessionFactory;

    public RowInHallDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<RowInHall> getByAllRows() {
        try (Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(RowInHall.class);
            return (List<RowInHall>) criteria.list();
        }
    }

    @Override
    public void update(RowInHall rowInHall) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(rowInHall);
        session.getTransaction().commit();
    }


}

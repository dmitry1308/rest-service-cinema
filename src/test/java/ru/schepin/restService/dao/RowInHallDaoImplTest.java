package ru.schepin.restService.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.schepin.restService.model.RowInHall;

public class RowInHallDaoImplTest {
    SessionFactory sessionFactory;
    RowInHallDao<RowInHall, Integer> rowInHallDao;
    RowInHall rowInHall;

    @Before
    public void before() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        rowInHallDao = new RowInHallDaoImpl(sessionFactory);
    }

    @Before
    public void after() {
 //       sessionFactory.close();
    }

    @Test
    public void whenGetRowByIdThenRowExist() {
        Assert.assertNotNull(rowInHallDao.getByKey(1));

    }
}

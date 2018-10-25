package ru.schepin.restService.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.schepin.restService.model.User;

import java.util.List;

public class UserDaoImplTest {
    private SessionFactory sessionFactory;
    private UserDao<User, Integer,String> userDao;
    private User user = new User();
    private int id;


    @Before
    public void before() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        userDao = new UserDaoImpl(sessionFactory);

    }


    @After
    public void after() {
        if (userDao.getByKey(id) != null) {
            userDao.delete(user);
        }
        sessionFactory.close();
    }


    @Test
    public void whenSaveUserThenUserIsExist() {
        user = new User("men", "men");

        userDao.save(user);
        User findedUser=new User();
        List<User> allUser = userDao.getByAllUser();
        for (int i = 0; i <allUser.size() ; i++) {
            if (allUser.get(i).getPassword().equals("men")) {
                findedUser = allUser.get(i);
                id = findedUser.getId();
            }
        }

        Assert.assertEquals(user, findedUser);
    }

}

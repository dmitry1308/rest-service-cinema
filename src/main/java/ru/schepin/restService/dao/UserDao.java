package ru.schepin.restService.dao;

import java.util.List;

public interface UserDao<Entity, Key, Password> {
    void save(Entity entity);

    Entity getByKey(Key key);

    Entity getByPassword(Password password);

    List<Entity> getByAllUser();

    void update(Entity entity);

    void delete(Entity entity);
}

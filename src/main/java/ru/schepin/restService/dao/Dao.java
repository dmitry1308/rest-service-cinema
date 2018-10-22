package ru.schepin.restService.dao;

import java.util.List;

public interface Dao<Entity,Key> {
    void save(Entity entity);

    Entity getByKey(Key key);

    List<Entity> getByAllUser();

    void update(Entity entity);

    void delete(Entity entity);
}

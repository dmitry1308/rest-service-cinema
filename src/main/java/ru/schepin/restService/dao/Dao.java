package ru.schepin.restService.dao;

public interface Dao<Entity,Key> {
    void save(Entity entity);

    Entity getByKey(Key key);

    void update(Entity entity);

    void delete(Entity entity);
}

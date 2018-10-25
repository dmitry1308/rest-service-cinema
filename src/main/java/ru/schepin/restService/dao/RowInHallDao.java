package ru.schepin.restService.dao;

import java.util.List;

public interface RowInHallDao<Entity,Key> {
    List<Entity> getByAllRows();

    void update(Entity entity);

    Entity getByKey(Key id);
}

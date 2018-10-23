package ru.schepin.restService.dao;

import java.util.List;

public interface RowInHallDao<Entity> {
    List<Entity> getByAllRows();
}

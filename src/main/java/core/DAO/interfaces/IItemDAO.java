/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IItemDAO<T> {
    void create(T item);

    T getById(int id);

    void removeById(int id);

    void update(T item);
}

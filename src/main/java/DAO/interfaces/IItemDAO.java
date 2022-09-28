/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IItemDAO<T> {
    void create(T item);

    T getById(int id);

    void removeById(int id);

    void update(T item);
}

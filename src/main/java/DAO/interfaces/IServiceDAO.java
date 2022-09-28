/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IServiceDAO<T> {
    void create(T service);

    T getById(int id);

    void removeById(int id);

    void update(T service);
}

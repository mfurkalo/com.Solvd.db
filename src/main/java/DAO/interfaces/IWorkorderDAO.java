/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IWorkorderDAO<T> {
    void create(T workorder);

    T getById(int id);

    void removeById(int id);

    void update(T workorder);
}

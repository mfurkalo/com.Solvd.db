/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IUserDAO<T> {
    void create(T user);

    T getById(int id);

    void removeById(int id);

    void update(T user);
}
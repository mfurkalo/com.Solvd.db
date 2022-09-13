/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IUserDAO<T> {
    void create(T user);

    T getById(int id);

    void removeById(int id);

    void update(T user);
}

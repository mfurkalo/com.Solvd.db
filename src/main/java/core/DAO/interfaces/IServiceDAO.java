/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IServiceDAO<T> {
    void create(T service);

    T getById(int id);

    void removeById(int id);

    void update(T service);
}

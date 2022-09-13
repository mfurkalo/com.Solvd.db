/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IWorkorderDAO<T> {
    void create(T workorder);

    T getById(int id);

    void removeById(int id);

    void update(T workorder);
}

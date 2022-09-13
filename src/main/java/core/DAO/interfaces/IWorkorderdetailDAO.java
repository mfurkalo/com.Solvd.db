/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IWorkorderdetailDAO<T> {
    void create(T workOrderDetail);

    T getById(int id);

    void removeById(int id);

    void update(T workOrderDetail);
}

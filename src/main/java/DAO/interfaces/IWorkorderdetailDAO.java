/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IWorkorderdetailDAO<T> {
    void create(T workOrderDetail);

    T getById(int id);

    void removeById(int id);

    void update(T workOrderDetail);
}

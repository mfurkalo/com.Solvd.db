/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IPaymentDAO<T> {
    void create(T payment);

    T getById(int id);

    void removeById(int id);

    void update(T payment);
}

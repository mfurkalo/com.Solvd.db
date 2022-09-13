/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IPaymentDAO<T> {
    void create(T payment);

    T getById(int id);

    void removeById(int id);

    void update(T payment);
}

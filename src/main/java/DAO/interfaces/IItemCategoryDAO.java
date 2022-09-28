/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IItemCategoryDAO<T> {
    void create(T itemCategory);

    T getById(int id);

    void removeById(int id);

    void update(T itemCategory);
}

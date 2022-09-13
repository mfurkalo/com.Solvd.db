/*
 * Copyright (c) 2022.  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IItemCategoryDAO<T> {
    void create(T itemCategory);

    T getById(int id);

    void removeById(int id);

    void update(T itemCategory);
}

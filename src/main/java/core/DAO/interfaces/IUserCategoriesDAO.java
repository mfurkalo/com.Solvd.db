/*
 * Copyright (c)  by Maksym Furkalo
 * use it for free
 */

package core.DAO.interfaces;

public interface IUserCategoriesDAO<T> {
    void create(T userGroup);

    T getById(int id);

    void removeById(int id);

    void update(T userGroup);
}

/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.interfaces;

public interface IUserGroupsDAO<T> {
    void create(T userGroup);

    T getById(int id);

    void removeById(int id);

    void update(T userGroup);
}

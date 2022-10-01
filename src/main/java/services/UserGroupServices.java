/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package services;

import DAO.interfaces.IUserGroupsDAO;
import DAO.models.UserGroup;
import DAO.mybatis.UserGroupDao;

public class UserGroupServices {
    private static IUserGroupsDAO<UserGroup> userGroupsDAO = new UserGroupDao();

    public static UserGroup getById(int id) {
        return userGroupsDAO.getById(id);
    }

    public static void create(UserGroup userGroup) {
        userGroupsDAO.create(userGroup);
    }

    public static void removeById(int id) {
        userGroupsDAO.removeById(id);
    }

    public static void update(UserGroup userGroup) {
        userGroupsDAO.update(userGroup);
    }
}

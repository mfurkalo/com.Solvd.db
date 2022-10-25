/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package services;

import DAO.interfaces.IBasicDAO;
import DAO.models.UserGroup;
import DAO.mybatis.DaoBatisFactory;
import utils.DaoType;

public class UserGroupServices {
    private static IBasicDAO<UserGroup> userGroupsDAO = new DaoBatisFactory().getDao(DaoType.USER_GROUP);

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

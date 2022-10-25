/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package services;

import DAO.interfaces.IBasicDAO;
import DAO.models.User;
import DAO.mybatis.DaoBatisFactory;
import utils.DaoType;

public class UserServices {
    private static IBasicDAO<User> userDAO = new DaoBatisFactory().getDao(DaoType.USER);

    public static User getById(int id) {
        return userDAO.getById(id);
    }

    public static void create(User user) {
        userDAO.create(user);
    }

    public static void removeById(int id) {
        userDAO.removeById(id);
    }

    public static void update(User user) {
        userDAO.update(user);
    }
}

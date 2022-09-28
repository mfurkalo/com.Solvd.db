/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package services;

import DAO.interfaces.IUserDAO;
import DAO.models.User;
import DAO.mySQL.UserDao;

public class UserServices {
    private static IUserDAO<User> userDAO = new UserDao();

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

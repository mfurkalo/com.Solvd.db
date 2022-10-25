/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IUserDAO;
import DAO.models.User;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisFactory;

public class UserDao implements IUserDAO<User> {
    @Override
    public void create(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserDAO.class).create(user);
        session.commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        User result = (User) session.getMapper(IUserDAO.class).getById(id);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public void removeById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserDAO.class).removeById(id);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserDAO.class).update(user);
        session.commit();
        session.close();
    }
}

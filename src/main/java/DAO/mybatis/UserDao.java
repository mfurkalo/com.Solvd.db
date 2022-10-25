/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IBasicDAO;
import DAO.models.User;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisFactory;

public class UserDao implements IBasicDAO<User> {
    @Override
    public void create(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IBasicDAO.class).create(user);
        session.commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        User result = (User) session.getMapper(IBasicDAO.class).getById(id);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public void removeById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IBasicDAO.class).removeById(id);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IBasicDAO.class).update(user);
        session.commit();
        session.close();
    }
}

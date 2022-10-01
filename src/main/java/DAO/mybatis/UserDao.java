/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IUserDAO;
import DAO.models.User;
import DAO.mybatis.mapper.IUserMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisFactory;

public class UserDao implements IUserDAO<User> {
    @Override
    public void create(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserMapper.class).createUser(user);
        session.commit();
        session.close();
    }

    @Override
    public User getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        User result = session.getMapper(IUserMapper.class).getById(id);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public void removeById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserMapper.class).deleteById(id);
        session.commit();
        session.close();
    }

    @Override
    public void update(User user) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserMapper.class).updateByName(user);
        session.commit();
        session.close();
    }
}

/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IUserGroupsDAO;
import DAO.models.UserGroup;
import DAO.mybatis.mapper.IUserGroupMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisFactory;

public class UserGroupDao implements IUserGroupsDAO<UserGroup> {
    @Override
    public void create(UserGroup userGroup) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserGroupMapper.class).createUserGroup(userGroup);
        session.commit();
        session.close();
    }

    @Override
    public UserGroup getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        UserGroup result = session.getMapper(IUserGroupMapper.class).getById(id);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public void removeById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserGroupMapper.class).deleteById(id);
        session.commit();
        session.close();
    }

    @Override
    public void update(UserGroup userGroup) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(IUserGroupMapper.class).updateByName(userGroup);
        session.commit();
        session.close();
    }
}

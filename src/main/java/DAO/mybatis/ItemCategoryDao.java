/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IBasicDAO;
import DAO.models.ItemCategory;
import DAO.mybatis.mapper.ItemCategoryMapper;
import org.apache.ibatis.session.SqlSession;
import utils.MyBatisFactory;

import java.util.List;

public class ItemCategoryDao implements IBasicDAO<ItemCategory> {
    @Override
    public void create(ItemCategory itemCategory) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ItemCategoryMapper.class).createItemCategory(itemCategory);
        session.commit();
        session.close();
    }

    @Override
    public ItemCategory getById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        ItemCategory result = session.getMapper(ItemCategoryMapper.class).getById(id);
        session.commit();
        session.close();
        return result;
    }

    @Override
    public void removeById(int id) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ItemCategoryMapper.class).deleteById(id);
        session.commit();
        session.close();
    }

    @Override
    public void update(ItemCategory itemCategory) {
        SqlSession session = MyBatisFactory.getSession();
        session.getMapper(ItemCategoryMapper.class).updateById(itemCategory);
        session.commit();
        session.close();
    }

    public List<ItemCategory> getAll() {
        SqlSession session = MyBatisFactory.getSession();
        List<ItemCategory> result = session.getMapper(ItemCategoryMapper.class).selectAll();
        session.commit();
        session.close();
        return result;
    }
}

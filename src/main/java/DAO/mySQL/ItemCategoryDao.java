/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import DAO.interfaces.IBasicDAO;
import DAO.models.ItemCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemCategoryDao extends ShopSqlDao implements IBasicDAO<ItemCategory> {
    private static final Logger log = LogManager.getLogger(ItemCategoryDao.class.getName());
    public static final String CREATE_ITEMCATEGORY = "insert into item_categories (name) value (?)";
    public static final String GET_ITEMCATEGORY_BY_ID = "select * from item_categories where  id = ?";
    public static final String GET_ALL = "select * from item_categories";
    public static final String DELETE_ITEMCATEGORY_BY_ID = "delete from item_categories where  id = ?";
    public static final String UPDATE_ITEMCATEGORY_BY_ID = "update item_categories set name = ? where id = ?";

    @Override
    public void create(ItemCategory itemCategory) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(CREATE_ITEMCATEGORY);
            ps.setString(1, itemCategory.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public ItemCategory getById(int id) {
        Connection c = null;
        ItemCategory itemCategory = new ItemCategory();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_ITEMCATEGORY_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                itemCategory.setId(rs.getInt(1));
                itemCategory.setName(rs.getString("name"));

            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return itemCategory;
    }

    @Override
    public void removeById(int id) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_ITEMCATEGORY_BY_ID);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public void update(ItemCategory itemCategory) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_ITEMCATEGORY_BY_ID);
            ps.setString(1, itemCategory.getName());
            ps.setInt(2, itemCategory.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    public List<ItemCategory> getAll() {
        Connection c = null;
        List<ItemCategory> result = new ArrayList<>();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItemCategory itemCategory = new ItemCategory();
                itemCategory.setId(rs.getInt(1));
                itemCategory.setName(rs.getString("name"));
                result.add(itemCategory);
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return result;
    }
}

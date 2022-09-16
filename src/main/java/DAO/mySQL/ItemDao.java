/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import DAO.interfaces.IItemDAO;
import DAO.models.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDao extends ShopSqlDao implements IItemDAO<Item> {
    private static final Logger log = LogManager.getLogger(ItemDao.class.getName());
    public static final String CREATE_ITEM = "insert into items (name, description, serial_no, amount, item_category," +
            " encoded_by) values (?, ?, ?, ?, ?, ?)";
    public static final String GET_ITEM_BY_ID = "select * from items where  id = ?";
    public static final String DELETE_ITEM_BY_ID = "delete from items where  id = ?";
    public static final String UPDATE_ITEM_BY_NAME = "update items set description = ?, serial_no = ?, amount = ?," +
            " item_category = ?, group_id = ? where name = ?";

    @Override
    public void create(Item item) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(CREATE_ITEM);
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setString(3, item.getSerial_no());
            ps.setFloat(4, item.getAmount());
            ps.setInt(5, item.getItem_category());
            ps.setInt(6, item.getEncoded_by());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public Item getById(int id) {
        Connection c = null;
        Item item = new Item();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_ITEM_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item.setId(rs.getInt(1));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setSerial_no(rs.getString("serial_no"));
                item.setAmount(rs.getFloat("amount"));
                item.setItem_category(rs.getInt("item_category"));
                item.setEncoded_by(rs.getInt("encoded_by"));
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return item;
    }

    @Override
    public void removeById(int id) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_ITEM_BY_ID);
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
    public void update(Item item) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_ITEM_BY_NAME);
            ps.setString(1, item.getDescription());
            ps.setString(2, item.getSerial_no());
            ps.setFloat(3, item.getAmount());
            ps.setInt(4, item.getItem_category());
            ps.setInt(5, item.getEncoded_by());
            ps.setString(6, item.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }
}

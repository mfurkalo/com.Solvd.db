/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import DAO.interfaces.IBasicDAO;
import DAO.models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends ShopSqlDao implements IBasicDAO<User> {
    private static final Logger log = LogManager.getLogger(UserDao.class.getName());
    public static final String CREATE_USER = "insert into users (username, password, fullname, phone, email, status," +
            "group_id) values (?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_USER_BY_ID = "select * from users where  id = ?";
    public static final String DELETE_USER_BY_ID = "delete from users where  id = ?";
    public static final String UPDATE_USER_BY_USERNAME = "update users set password = ?, fullname = ?, phone = ?," +
            "email = ?, status = ?, group_id = ? where username = ?";

    @Override
    public void create(User user) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(CREATE_USER);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullname());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getStatus());
            ps.setInt(7, user.getGroup_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public User getById(int id) {
        Connection c = null;
        User user = new User();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_USER_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("fullname"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setStatus(rs.getInt("status"));
                user.setGroup_id(rs.getInt("group_id"));
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return user;
    }

    @Override
    public void removeById(int id) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_USER_BY_ID);
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
    public void update(User user) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_USER_BY_USERNAME);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getFullname());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getEmail());
            ps.setInt(5, user.getStatus());
            ps.setInt(6, user.getGroup_id());
            ps.setString(7, user.getUsername());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }
}

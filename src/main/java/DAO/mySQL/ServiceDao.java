/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import DAO.interfaces.IBasicDAO;
import DAO.models.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceDao extends ShopSqlDao implements IBasicDAO<Service> {
    private static final Logger log = LogManager.getLogger(ServiceDao.class.getName());
    public static final String CREATE_SERVICE = "insert into services (name, description, amount) values (?, ?, ?)";
    public static final String GET_SERVICE_BY_ID = "select * from services where  id = ?";
    public static final String DELETE_SERVICE_BY_ID = "delete from services where  id = ?";
    public static final String UPDATE_SERVICE_BY_NAME = "update services set description = ?, amount = ? where name = ?";

    @Override
    public void create(Service service) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(CREATE_SERVICE);
            ps.setString(1, service.getName());
            ps.setString(2, service.getDescription());
            ps.setFloat(3, service.getAmount());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public Service getById(int id) {
        Connection c = null;
        Service service = new Service();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_SERVICE_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                service.setId(rs.getInt(1));
                service.setName(rs.getString("name"));
                service.setDescription(rs.getString("description"));
                service.setAmount(rs.getFloat("amount"));
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return service;
    }

    @Override
    public void removeById(int id) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_SERVICE_BY_ID);
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
    public void update(Service service) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_SERVICE_BY_NAME);
            ps.setString(1, service.getDescription());
            ps.setFloat(2, service.getAmount());
            ps.setString(3, service.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }
}

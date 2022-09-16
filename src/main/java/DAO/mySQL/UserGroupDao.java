/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import DAO.models.UserGroup;
import DAO.interfaces.IUserGroupsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class UserGroupDao extends ShopSqlDao implements IUserGroupsDAO<UserGroup> {
    private static final Logger log = LogManager.getLogger(UserGroupDao.class.getName());
    public static final String CREATE_USERGROUP = "insert into user_groups (name, description, allow_add, allow_edit," +
            " allow_delete, allow_print, allow_import, allow_export) values (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_USERGROUP_BY_ID = "select * from user_groups where  id = ?";
    public static final String DELETE_USERGROUP_BY_ID = "delete from user_groups where  id = ?";
    public static final String UPDATE_USERGROUP_BY_NAME = "update user_groups set description = ?, allow_add = ?," +
            " allow_edit = ?, allow_delete = ?, allow_print = ?, allow_import = ?, allow_export = ? where name = ?";

    @Override
    public void create(UserGroup userGroup) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(CREATE_USERGROUP);
            ps.setString(1, userGroup.getName());
            ps.setString(2, userGroup.getDescription());
            ps.setInt(3, userGroup.isAllowAdd() ? 1 : 0);
            ps.setInt(4, userGroup.isAllowEdit() ? 1 : 0);
            ps.setInt(5, userGroup.isAllowDelete() ? 1 : 0);
            ps.setInt(6, userGroup.isAllowPrint() ? 1 : 0);
            ps.setInt(7, userGroup.isAllowImport() ? 1 : 0);
            ps.setInt(8, userGroup.isAllowExport() ? 1 : 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }

    @Override
    public UserGroup getById(int id) {
        Connection c = null;
        UserGroup userGroup = new UserGroup();
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(GET_USERGROUP_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                userGroup.setId(rs.getInt(1));
                userGroup.setName(rs.getString("name"));
                userGroup.setDescription(rs.getString("description"));
                userGroup.setAllowAdd(rs.getInt("allow_add") > 0 ? true : false);
                userGroup.setAllowEdit(rs.getInt("allow_edit") > 0 ? true : false);
                userGroup.setAllowDelete(rs.getInt("allow_delete") > 0 ? true : false);
                userGroup.setAllowPrint(rs.getInt("allow_print") > 0 ? true : false);
                userGroup.setAllowImport(rs.getInt("allow_import") > 0 ? true : false);
                userGroup.setAllowExport(rs.getInt("allow_export") > 0 ? true : false);
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
        return userGroup;
    }

    @Override
    public void removeById(int id) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(DELETE_USERGROUP_BY_ID);
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
    public void update(UserGroup userGroup) {
        Connection c = null;
        try {
            c = getConnection();
            PreparedStatement ps = c.prepareStatement(UPDATE_USERGROUP_BY_NAME);
            ps.setString(1, userGroup.getDescription());
            ps.setInt(2, userGroup.isAllowAdd() ? 1 : 0);
            ps.setInt(3, userGroup.isAllowEdit() ? 1 : 0);
            ps.setInt(4, userGroup.isAllowDelete() ? 1 : 0);
            ps.setInt(5, userGroup.isAllowPrint() ? 1 : 0);
            ps.setInt(6, userGroup.isAllowImport() ? 1 : 0);
            ps.setInt(7, userGroup.isAllowExport() ? 1 : 0);
            ps.setString(8, userGroup.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e);
            throw new RuntimeException(e);
        } finally {
            releaseConnection(c);
        }
    }
}

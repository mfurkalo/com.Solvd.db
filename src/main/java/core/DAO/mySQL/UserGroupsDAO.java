/*
 * Copyright (c)  by Maksym Furkalo
 * use it for free
 */

package core.DAO.mySQL;

import core.DAO.models.UserGroup;
import core.DAO.interfaces.IUserCategoriesDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserGroupsDAO extends ShopSqlDao implements IUserCategoriesDAO<UserGroup> {

    private static final Logger log = LogManager.getLogger(UserGroupsDAO.class.getName());

    @Override
    public void create(UserGroup userGroup) {
        String sql = "insert into user_groups (name, description, allow_add, allow_edit, allow_delete, allow_print, \n" +
                "allow_import, allow_export) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, userGroup.getName());
            ps.setString(2, userGroup.getDescription());

            ResultSet rs = ps.executeQuery();

        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public UserGroup getById(int id) {
        String sql = "select * from  user_groups where  id = ?";
        UserGroup userGroup = new UserGroup();

        try {
            Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
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
            }
        } catch (SQLException e) {
            log.error("Error connecting to the DB ! " + e.getMessage());
            throw new RuntimeException(e);
        }
        return userGroup;
    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public void update(UserGroup userGroup) {

    }
}

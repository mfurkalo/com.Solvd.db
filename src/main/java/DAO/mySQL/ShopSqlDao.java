/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package DAO.mySQL;

import utils.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

import static utils.Base.properties;


abstract class ShopSqlDao {
    private static Connection conn = null;
    private static ConnectionPool cpool = null;

    static final Connection getConnection() throws SQLException {
        cpool = ConnectionPool.getInstance(properties.url(), properties.user(), properties.password());
        conn = cpool.getConnection();
        return conn;
    }

    static final void releaseConnection(Connection connection) {
        cpool.releaseConnection(connection);
    }

}

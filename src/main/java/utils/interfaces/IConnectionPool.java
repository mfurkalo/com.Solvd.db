/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionPool {
    Connection getConnection() throws SQLException;
    boolean releaseConnection(Connection connection);
    public void shutdown() throws SQLException;
    String getUrl();
    String getUser();
    String getPassword();
}

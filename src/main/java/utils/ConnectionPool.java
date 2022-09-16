/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils;

import utils.interfaces.IConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.Base.properties;

public class ConnectionPool implements IConnectionPool {
    private String url;
    private String user;
    private String password;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private static ConnectionPool instance;

    private ConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = pool;
    }


    public static synchronized ConnectionPool getInstance(String url, String user, String password) throws SQLException {
        if (instance == null) {
            List<Connection> pool = new ArrayList<>(properties.initialPoolSize());
            for (int i = 0; i < properties.initialPoolSize(); i++) {
                pool.add(createConnection(url, user, password));
            }
            instance = new ConnectionPool(url, user, password, pool);
        }
        return instance;
    }

    @Override
    public synchronized Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < properties.maxPoolSize()) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Pool size reached, no available connections");
            }
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        if (!connection.isValid(properties.maxTimeout())) {
            connection = createConnection(url, user, password);
        }
        usedConnections.add(connection);
        return connection;
    }

    @Override
    public void shutdown() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : connectionPool) {
            c.close();
        }
        connectionPool.clear();
    }

    @Override
    public synchronized boolean releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.add(connection);
        }
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public String getUrl() {
        return this.url;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}

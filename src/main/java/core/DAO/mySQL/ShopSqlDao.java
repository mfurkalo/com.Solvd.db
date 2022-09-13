package core.DAO.mySQL;

import com.mchange.v2.c3p0.ComboPooledDataSource;


import java.sql.Connection;
import java.sql.SQLException;


abstract class ShopSqlDao {
    private static final ComboPooledDataSource CPDS = new ComboPooledDataSource();

    static final Connection getConnection() throws SQLException {
        return CPDS.getConnection();
    }

}

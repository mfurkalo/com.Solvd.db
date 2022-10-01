/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(Boolean.class)
public class IntToBoolTypeHandler extends BaseTypeHandler<Integer> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        ps.setBoolean(i, convert(parameter));
    }

    @Override
    public Integer getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getBoolean(columnName));
    }

    @Override
    public Integer getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getBoolean(columnIndex));
    }

    @Override
    public Integer getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getBoolean(columnIndex));
    }

    private Boolean convert(Integer i) {
        return i > 0 ? true : false;
    }

    private Integer convert(Boolean b) {
        return b ? 1 : 0;
    }
}

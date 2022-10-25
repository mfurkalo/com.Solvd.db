/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis.mapper;

import DAO.models.User;
import org.apache.ibatis.annotations.*;

public interface IUserMapper {
    String getById = "SELECT * FROM users WHERE id = #{id}";
    String createUser = "INSERT INTO users (username, password, fullname, phone, email, status, group_id) VALUES" +
            " (#{username}, #{password}, #{fullname}, #{phone}, #{email}, #{status}, #{group_id})";
    String deleteById = "DELETE FROM users WHERE  id = #{id}";
    String updateByName = "UPDATE users SET password = #{password}, fullname = #{fullname}, phone" +
            " = #{phone}, email = #{email}, status = #{status}, group_id = #{group_id} WHERE username = #{username}";

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "fullname", column = "fullname"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "status", column = "status"),
            @Result(property = "group_id", column = "group_id"),
    })
    User getById(int id);

    @Insert(createUser)
    void createUser(User user);

    @Delete(deleteById)
    void deleteById(int id);

    @Update(updateByName)
    void updateByName(User user);
}

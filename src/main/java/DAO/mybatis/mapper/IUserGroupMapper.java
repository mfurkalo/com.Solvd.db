/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis.mapper;

import DAO.models.UserGroup;
import DAO.mybatis.IntToBoolTypeHandler;
import org.apache.ibatis.annotations.*;

public interface IUserGroupMapper {
    String getById = "SELECT * FROM user_groups WHERE id = #{id}";
    String createUserGroup = "INSERT INTO user_groups (name, description, allow_add, allow_edit, allow_delete," +
            " allow_print, allow_import, allow_export) VALUES (#{name}, #{description}, #{allow_add}, #{allow_edit}," +
            " #{allow_delete}, #{allow_print}, #{allow_import}, #{allow_export})";
    String deleteById = "DELETE FROM user_groups WHERE  id = #{id}";
    String updateByName = "UPDATE user_groups SET description = #{description}, allow_add = #{allow_add}, allow_edit" +
            " = #{allow_edit}, allow_delete = #{allow_delete}, allow_print = #{allow_print}, allow_import =" +
            " #{allow_import}, allow_export = #{allow_export}  WHERE name = #{name}";

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "allowAdd", column = "allow_add"),
            @Result(property = "allowEdit", column = "allow_edit"),
            @Result(property = "allowDelete", column = "allow_delete"),
            @Result(property = "allowPrint", column = "allow_print"),
            @Result(property = "allowImport", column = "allow_import"),
            @Result(property = "allowExport", column = "allow_export")
    })
    UserGroup getById(int id);

    @Insert(createUserGroup)
    void createUserGroup(UserGroup userGroup);

    @Delete(deleteById)
    void deleteById(int id);

    @Update(updateByName)
    void updateByName(UserGroup userGroup);
}

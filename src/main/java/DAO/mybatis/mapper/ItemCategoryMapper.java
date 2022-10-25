/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis.mapper;

import DAO.models.ItemCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemCategoryMapper {
    String selectAll = "SELECT * FROM item_categories";
    String getById = "SELECT * FROM item_categories WHERE id = #{id}";
    String createItemCategory = "INSERT INTO item_categories (name) VALUES (#{name})";
    String deleteById = "DELETE FROM item_categories WHERE  id = #{id}";
    String updateById = "UPDATE item_categories SET name = #{name} WHERE id = #{id}";

    @Select(selectAll)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    List<ItemCategory> selectAll();

    @Select(getById)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    ItemCategory getById(int id);

    @Insert(createItemCategory)
    void createItemCategory(ItemCategory ic);

    @Delete(deleteById)
    void deleteById(int id);

    @Update(updateById)
    void updateById(ItemCategory ic);
}

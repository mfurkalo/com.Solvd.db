package DAO.mybatis;

import DAO.models.ItemCategory;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemCategoryMapper {
    String selectAll ="SELECT * FROM item_categories";
    @Select(selectAll)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    List<ItemCategory> selectAll();
}

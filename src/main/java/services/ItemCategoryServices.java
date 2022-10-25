/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package services;

import DAO.interfaces.IItemCategoryDAO;
import DAO.models.ItemCategory;
import DAO.mybatis.ItemCategoryDao;


public class ItemCategoryServices {
    private static IItemCategoryDAO<ItemCategory> itemCategoryDAO = new ItemCategoryDao();

    public static ItemCategory getById(int id) {
        return itemCategoryDAO.getById(id);
    }

    public static void create(ItemCategory itemCategory) {
        itemCategoryDAO.create(itemCategory);
    }

    public static void removeById(int id) {
        itemCategoryDAO.removeById(id);
    }

    public static void update(ItemCategory itemCategory) {
        itemCategoryDAO.update(itemCategory);
    }

}

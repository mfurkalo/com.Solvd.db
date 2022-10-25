/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mybatis;

import DAO.interfaces.IBasicDAO;
import utils.DaoType;

public class DaoBatisFactory {
    public IBasicDAO getDao(DaoType daoType) {

        switch (daoType) {
            case ITEM_CATEGORY:
                return new ItemCategoryDao();
            case ITEM:
            case SERVICE:
            case USER:
                return new UserDao();
            case USER_GROUP:
                return new UserGroupDao();
            default:
                return null;
        }
    }
}

/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package DAO.mySQL;

import DAO.interfaces.IBasicDAO;
import utils.DaoType;

public class DaoSqlFactory {

    public IBasicDAO getDao(DaoType daoType) {

        switch (daoType) {
            case ITEM_CATEGORY:
                return new ItemCategoryDao();
            case ITEM:
                return new ItemDao();
            case SERVICE:
                return new ServiceDao();
            case USER:
                return new UserDao();
            case USER_GROUP:
                return new UserGroupDao();
            default:
                return null;
        }
    }
}

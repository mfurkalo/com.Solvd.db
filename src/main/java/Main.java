/*
 * Copyright (c)  by Maksym Furkalo
 * use it for free
 */

import core.DAO.mySQL.UserGroupsDAO;

public class Main {
   static UserGroupsDAO usRrs = new UserGroupsDAO();


    public static void main(String[] args) {
        System.out.println(usRrs.getById(3));
    }

}
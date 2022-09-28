/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package core;

import DAO.models.User;
import DAO.models.UserGroup;
import DAO.mySQL.ItemCategoryDao;
import services.UserGroupServices;
import services.UserServices;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        dbOperations();
    }

    public static void dbOperations() {
        Main main = new Main();
        System.out.println(UserGroupServices.getById(2));
        UserGroupServices.create(main.testUserGroup());
        UserGroupServices.removeById(10);
        System.out.println(UserServices.getById(6));
        UserServices.update(main.testUser2());
        UserServices.removeById(6);
        List result = new ItemCategoryDao().getAll();
        result.forEach(i -> System.out.println(i));
    }

    UserGroup testUserGroup() {
        UserGroup userGroup = new UserGroup();
        userGroup.setName("tester6");
        userGroup.setDescription("description");
        userGroup.setAllowAdd(true);
        userGroup.setAllowEdit(true);
        userGroup.setAllowDelete(false);
        userGroup.setAllowPrint(true);
        userGroup.setAllowImport(false);
        userGroup.setAllowExport(true);
        return userGroup;
    }

    User testUser() {
        User user = new User();
        user.setUsername("fortest");
        user.setPassword("1235h");
        user.setFullname("Georg First");
        user.setPhone("11150689567");
        user.setEmail("sample@email.com");
        user.setStatus(1);
        user.setGroup_id(6);
        return user;
    }

    User testUser2() {
        User user = new User();
        user.setUsername("fortest");
        user.setPassword("1h");
        user.setFullname("Georg Updated");
        user.setPhone("1113333567");
        user.setEmail("sample2@email.com");
        user.setStatus(0);
        user.setGroup_id(6);
        return user;
    }
}
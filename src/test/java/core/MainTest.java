/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package core;

import DAO.models.User;
import DAO.models.UserGroup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    static Logger log = LogManager.getLogger(MainTest.class.getName());

    @Test
    public void testTestUserGroupPositive() {
        log.info("MainTest 1");
        Assert.assertTrue((new Main().testUserGroup() instanceof UserGroup)
                , "An instance of UserGroup.class expected");
    }

    @Test
    public void testTestUserGroupContains() {
        log.info("MainTest 2");
        Assert.assertTrue(new Main().testUserGroup().getName().contains("tester6"), "It should contain 'tester6'");
    }

    @Test
    public void testTestUserPositive() {
        log.info("MainTest 3");
        Assert.assertTrue((new Main().testUser() instanceof User), "An instance of User.class expected");
    }

    @Test
    public void testTestUserContains() {
        log.info("MainTest 4");
        Assert.assertTrue(new Main().testUser().getUsername().contains("fortest"), "It should contain 'fortest'");
    }

    @Test
    public void testTestUser2Null() {
        log.info("MainTest 5");
        Assert.assertNotNull((new Main().testUser2() instanceof User), "Not nullable User.class object is expected");
    }

    @Test
    public void testTestUsers() {
        log.info("MainTest 6");
        Assert.assertNotSame(new Main().testUser2(), new Main().testUser(), "Not the same is expected");
    }
}
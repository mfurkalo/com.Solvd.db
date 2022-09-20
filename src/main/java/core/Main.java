/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package core;

import DAO.models.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import saxHandlers.*;
import services.UserGroupServices;
import services.UserServices;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    static Logger log = LogManager.getLogger(Main.class.getName());
    public static final String ITEM_CATEGORY_PATH = "src/main/resources/xml/ItemCategory.xml";
    public static final String SERVICE_PATH = "src/main/resources/xml/Service.xml";
    public static final String SERVICE_XSD = "src/main/resources/xml/Service.xsd";
    public static final String USER_GROUP_PATH = "src/main/resources/xml/UserGroup.xml";
    public static final String WORKORDER_DETAIL_PATH = "src/main/resources/xml/WorkorderDetail.xml";

    public static void main(String[] args) {
        dbOperations();

        try {
            xmlSaxOperation();
        } catch (ParserConfigurationException e) {
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (SAXException e) {
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.log(Level.FATAL, "The file is not found");
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public static void dbOperations() {
        Main main = new Main();
        System.out.println(UserGroupServices.getById(2));
        UserGroupServices.create(main.testUserGroup());
        UserGroupServices.removeById(10);
        System.out.println(UserServices.getById(6));
        UserServices.update(main.testUser2());
        UserServices.removeById(6);
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


    public static void xmlSaxOperation() throws ParserConfigurationException, SAXException, IOException {
        ItemCategoryHandler itemCategoryHandler = new ItemCategoryHandler();
        ServiceHandler serviceHandler = new ServiceHandler();
        UserGroupHandler userGroupHandler = new UserGroupHandler();
        WorkorderDetailHandler workorderDetailHandler = new WorkorderDetailHandler();
        ItemCategory iCat = ((ItemCategoryHandler) new Parser().parceSax(ITEM_CATEGORY_PATH, itemCategoryHandler))
                .getItemCategory();
        System.out.println("Parsed item category: " + iCat);
        Service ser = ((ServiceHandler) new Parser().parceSax(SERVICE_PATH, serviceHandler)).getService();
        System.out.println("Parsed service : " + ser);
        UserGroup uGroup1 = ((UserGroupHandler) new Parser().parceSax(USER_GROUP_PATH, userGroupHandler)).getUserGroup();
        System.out.println("Parsed user group : " + uGroup1);
        Workorderdetail workOrDet = ((WorkorderDetailHandler) new Parser().parceSax(WORKORDER_DETAIL_PATH
                , workorderDetailHandler)).getWorkorderdetail();
        System.out.println("Parsed workorder detail : " + workOrDet);
        System.out.println("Is the Service.xml valid: " + new Parser().validate(SERVICE_XSD, SERVICE_PATH));
    }
}
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
import saxHandlers.ItemCategoryHandler;
import saxHandlers.ServiceHandler;
import saxHandlers.UserGroupHandler;
import saxHandlers.WorkorderDetailHandler;
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
        ItemCategory iCat = new Parser().parceSax(ITEM_CATEGORY_PATH, new ItemCategoryHandler()).getItemCategory();
        System.out.printf("Parsed item category: %s\n", iCat);
        Service ser = new Parser().parceSax(SERVICE_PATH, new ServiceHandler()).getService();
        System.out.printf("Parsed service: %s\n", ser);
        UserGroup uGroup1 = new Parser().parceSax(USER_GROUP_PATH, new UserGroupHandler()).getUserGroup();
        System.out.printf("Parsed user group: %s\n", uGroup1);
        Workorderdetail workOrDet = new Parser().parceSax(WORKORDER_DETAIL_PATH, new WorkorderDetailHandler())
                .getWorkorderdetail();
        System.out.printf("Parsed workorder detail: %s\n", workOrDet);
        System.out.printf("Is the Service.xml valid? : %s", new Parser().validate(SERVICE_XSD, SERVICE_PATH));
    }
}
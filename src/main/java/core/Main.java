/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package core;

import DAO.models.*;
import DAO.mySQL.ItemCategoryDao;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import saxHandlers.ItemCategoryHandler;
import saxHandlers.ServiceHandler;
import saxHandlers.UserGroupHandler;
import saxHandlers.WorkorderDetailHandler;
import services.UserGroupServices;
import services.UserServices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.List;

public class Main {
    static Logger log = LogManager.getLogger(Main.class.getName());
    public static final String ITEM_CATEGORY_PATH = "src/main/resources/xml/ItemCategory.xml";
    public static final String ITEM_CATEGORIES_PATH = "src/main/resources/xml/ItemCategories.xml";
    public static final String ITEM_CATEGORY_XSD_PATH = "src/main/resources/xml/ItemCategory.xsd";
    public static final String SERVICE_PATH = "src/main/resources/xml/Service.xml";
    public static final String SERVICE_XSD_PATH = "src/main/resources/xml/Service.xsd";
    public static final String USER_GROUP_PATH = "src/main/resources/xml/UserGroup.xml";
    public static final String WORKORDER_DETAIL_PATH = "src/main/resources/xml/WorkorderDetail.xml";
    public static final String WORKORDER_DETAIL_XSD_PATH = "src/main/resources/xml/WorkorderDetail.xsd";
    public static final String WORKORDER_DETAIL_JSN_PATH = "src/main/resources/json/WorkorderDetail.json";
    public static final String USER_GROUP_JSN_PATH = "src/main/resources/json/UserGroup.json";

    public static void main(String[] args) {
        dbOperations();
        xmlSaxOperation();
        xmlJaxbOperation();
        jsonOperations();
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

    public static void xmlSaxOperation() {
        ItemCategory iCat = new Parser().parse(ITEM_CATEGORY_PATH, new ItemCategoryHandler()).getItemCategories().get(0);
        System.out.printf("Parsed item category: %s\n", iCat);
        var itemCategories = new Parser().parse(ITEM_CATEGORIES_PATH, new ItemCategoryHandler())
                .getItemCategories();
        itemCategories.forEach(i -> System.out.println(i));
        System.out.printf("Is the ItemCategories.xml valid? : %s\n", new Parser().validate(ITEM_CATEGORY_XSD_PATH
                , ITEM_CATEGORIES_PATH));
        Service ser = new Parser().parse(SERVICE_PATH, new ServiceHandler()).getService();
        System.out.printf("Parsed service: %s\n", ser);
        UserGroup uGroup1 = new Parser().parse(USER_GROUP_PATH, new UserGroupHandler()).getUserGroup();
        System.out.printf("Parsed user group: %s\n", uGroup1);
        Workorderdetail workOrDet = new Parser().parse(WORKORDER_DETAIL_PATH, new WorkorderDetailHandler())
                .getWorkorderdetail();
        System.out.printf("Parsed workorder detail: %s\n", workOrDet);
        System.out.printf("Is the Service.xml valid? : %s\n", new Parser().validate(SERVICE_XSD_PATH, SERVICE_PATH));
        System.out.printf("Is the WorkorderDetail.xml valid? : %s\n", new Parser().validate(WORKORDER_DETAIL_XSD_PATH
                , WORKORDER_DETAIL_PATH));
    }

    public static void marshal() throws JAXBException {

        ItemCategory icat = new ItemCategory();
        icat.setId(34);
        icat.setName("Universal Category");
        JAXBContext context = JAXBContext.newInstance(ItemCategory.class);
        Marshaller mar = context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(icat, System.out);
    }

    public static void xmlJaxbOperation() {
        Service ser = new ParseJaxb().parse(SERVICE_PATH, Service.class);
        System.out.printf("Parsed service: %s\n", ser);
        System.out.printf("Is the Service.xml valid? : %s\n", new ParseJaxb().validate(SERVICE_XSD_PATH, SERVICE_PATH
                , Service.class));
        ItemCategory iCat = new ParseJaxb().parse(ITEM_CATEGORY_PATH, ItemCategory.class);
        System.out.printf("Parsed item category: %s\n", iCat);
        UserGroup uGroup1 = new ParseJaxb().parse(USER_GROUP_PATH, UserGroup.class);
        System.out.printf("Parsed user group: %s\n", uGroup1);
        Workorderdetail workOrDet = new ParseJaxb().parse(WORKORDER_DETAIL_PATH, Workorderdetail.class);
        System.out.printf("Parsed workorder detail: %s\n", workOrDet);
        System.out.printf("Is the WorkorderDetail.xml valid? : %s\n", new ParseJaxb().validate(WORKORDER_DETAIL_XSD_PATH
                , WORKORDER_DETAIL_PATH, Workorderdetail.class));
        try {
            marshal();
        } catch (JAXBException e) {
            log.log(Level.FATAL, e.getMessage(), e);
        }
    }

    public static void jsonOperations() {
        JacksonReadWrite jReadWrite = new JacksonReadWrite();
        ItemCategory icat = new ItemCategory();
        icat.setId(34);
        icat.setName("Universal Category");
        System.out.println("RESULT: \n" + jReadWrite.unmarshal(icat));
        System.out.println("RESULT dao: \n" + jReadWrite.marshall(WORKORDER_DETAIL_JSN_PATH, Workorderdetail.class));
        System.out.println("RESULT dao: \n" + jReadWrite.marshall(USER_GROUP_JSN_PATH, UserGroup.class));
    }
}
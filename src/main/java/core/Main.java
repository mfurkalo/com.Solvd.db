/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package core;

import DAO.models.*;
import DAO.mybatis.ItemCategoryDao;
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
        System.out.println(UserServices.getById(2));
        UserServices.create(main.testUser());
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
        return new UserGroup.Builder(1, "tester66")
                .description("new description")
                .permissions(true, true, false, true, false, true)
                .build();
    }

    User testUser() {
        return new User.Builder(3, "Newtester")
                .password("123567h")
                .fullname("Donald Trump")
                .phone("123456895")
                .email("sample3@email.com")
                .status(2)
                .group_id(6)
                .build();
    }

    User testUser2() {
        return new User.Builder(9, "fortest")
                .password("12356789")
                .fullname("Georg Updated")
                .phone("1113333567")
                .email("sample2@email.com")
                .status(0)
                .group_id(6)
                .build();
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

        var icat = new ItemCategory.Builder("Universal Category")
                .id(34)
                .build();
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
        var icat = new ItemCategory.Builder("Test Category")
                .id(33)
                .build();
        System.out.println("RESULT: \n" + jReadWrite.unmarshal(icat));
        System.out.println("RESULT dao: \n" + jReadWrite.marshall(WORKORDER_DETAIL_JSN_PATH, Workorderdetail.class));
        System.out.println("RESULT dao: \n" + jReadWrite.marshall(USER_GROUP_JSN_PATH, UserGroup.class));
    }
}
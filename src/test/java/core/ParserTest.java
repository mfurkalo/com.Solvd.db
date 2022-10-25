/*
 * Copyright (c)
 *   * Maksym Furkalo,
 *   * work with DB using the DAO pattern,
 *   * use for free
 */

package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import saxHandlers.ItemCategoryHandler;

import static core.Main.*;

public class ParserTest {
    static Logger log = LogManager.getLogger(ParserTest.class.getName());

    @Test
    public void testParsePositive() {
        log.info("test 1");
        Assert.assertNotNull(new Parser().parse(ITEM_CATEGORY_PATH, new ItemCategoryHandler()).getItemCategories()
                .get(0), "The result should be not null");
    }

    @Test
    public void testParseNegative() {
        log.info("test 2");
        Assert.assertThrows(Exception.class, () -> new Parser().parse(SERVICE_PATH, new ItemCategoryHandler()));
    }

    @Test
    public void testValidatePositive() {
        log.info("test 3");
        Assert.assertFalse(new Parser().validate(ITEM_CATEGORY_XSD_PATH, ITEM_CATEGORIES_PATH)
                , "False is expected");
    }

    @Test
    public void testValidateNegative() {
        log.info("test 2");
        Assert.assertFalse(new Parser().validate(WORKORDER_DETAIL_XSD_PATH, ITEM_CATEGORIES_PATH)
                , "False is expected");
    }
}
/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package saxHandlers;

import DAO.models.ItemCategory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ItemCategoryHandler extends DefaultHandler {
    private List<ItemCategory> itemCategories;

    private static final String ITEMCATEGORIES = "ItemCategories";
    private static final String ITEMCATEGORY = "ItemCategory";
    private static final String ID = "id";
    private static final String NAME = "name";
    private StringBuilder elementValue;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (elementValue == null) {
            elementValue = new StringBuilder();
        } else {
            elementValue.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        itemCategories = new ArrayList();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ITEMCATEGORIES:
                itemCategories = new ArrayList<>();
                break;
            case ITEMCATEGORY:
                itemCategories.add(new ItemCategory());
                break;
            case ID:
                elementValue = new StringBuilder();
                break;
            case NAME:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
                latestItemCategory().setId(Integer.parseInt(elementValue.toString()));
                break;
            case NAME:
                latestItemCategory().setName(elementValue.toString());
                break;
        }
    }

    private ItemCategory latestItemCategory() {
        int latestItemCategoryIndex = itemCategories.size() - 1;
        return itemCategories.get(latestItemCategoryIndex);

    }

    public List<ItemCategory> getItemCategories() {
        return itemCategories;
    }
}

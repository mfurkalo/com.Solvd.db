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

public class ItemCategoryHandler extends DefaultHandler {
    private static final String ID = "id";
    private static final String NAME = "name";
    private ItemCategory itemCategory;
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
        itemCategory = new ItemCategory();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
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
                itemCategory.setId(Integer.parseInt(elementValue.toString()));
                break;
            case NAME:
                itemCategory.setName(elementValue.toString());
                break;
        }
    }

    public ItemCategory getItemCategory() {
        return this.itemCategory;
    }
}

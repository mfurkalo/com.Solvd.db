/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package saxHandlers;

import DAO.models.Workorderdetail;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WorkorderDetailHandler extends DefaultHandler {
    private static final String ID = "id";
    private static final String QUANTITY = "quantity";
    private static final String AMOUNT = "amount";
    private static final String TOTAL = "total";
    private static final String WORKORDER_ID = "workorder_id";
    private static final String ITEM_ID = "item_id";
    private Workorderdetail workorderdetail;
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
        workorderdetail = new Workorderdetail();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case ID:
                elementValue = new StringBuilder();
                break;
            case QUANTITY:
                elementValue = new StringBuilder();
                break;
            case AMOUNT:
                elementValue = new StringBuilder();
                break;
            case TOTAL:
                elementValue = new StringBuilder();
                break;
            case WORKORDER_ID:
                elementValue = new StringBuilder();
                break;
            case ITEM_ID:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
                workorderdetail.setId(Integer.parseInt(elementValue.toString()));
                break;
            case QUANTITY:
                workorderdetail.setQuantity(Integer.parseInt(elementValue.toString()));
                break;
            case AMOUNT:
                workorderdetail.setAmount(Float.parseFloat(elementValue.toString()));
                break;
            case TOTAL:
                workorderdetail.setTotal(Float.parseFloat(elementValue.toString()));
                break;
            case WORKORDER_ID:
                workorderdetail.setWorkorder_id(Integer.parseInt(elementValue.toString()));
                break;
            case ITEM_ID:
                workorderdetail.setItem_id(Integer.parseInt(elementValue.toString()));
                break;
        }
    }

    public Workorderdetail getWorkorderdetail() {
        return this.workorderdetail;
    }
}

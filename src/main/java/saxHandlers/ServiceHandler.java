/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package saxHandlers;

import DAO.models.Service;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ServiceHandler extends DefaultHandler {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String AMOUNT = "amount";

    private Service service;
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
        service = new Service();
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
            case DESCRIPTION:
                elementValue = new StringBuilder();
                break;
            case AMOUNT:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
                service.setId(Integer.parseInt(elementValue.toString()));
                break;
            case NAME:
                service.setName(elementValue.toString());
                break;
            case DESCRIPTION:
                service.setDescription(elementValue.toString());
                break;
            case AMOUNT:
                service.setAmount(Float.parseFloat(elementValue.toString()));
                break;
        }
    }

    public Service getService() {
        return this.service;
    }
}

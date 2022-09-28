/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package saxHandlers;

import DAO.models.UserGroup;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserGroupHandler extends DefaultHandler {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";
    private static final String ALLOWADD = "allowAdd";
    private static final String ALLOWEDIT = "allowEdit";
    private static final String ALLOWDELETE = "allowDelete";
    private static final String ALLOWPRINT = "allowPrint";
    private static final String ALLOWIMPORT = "allowImport";
    private static final String ALLOWEXPORT = "allowExport";
    private UserGroup userGroup;
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
        userGroup = new UserGroup();
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
            case ALLOWADD:
                elementValue = new StringBuilder();
                break;
            case ALLOWEDIT:
                elementValue = new StringBuilder();
                break;
            case ALLOWDELETE:
                elementValue = new StringBuilder();
                break;
            case ALLOWPRINT:
                elementValue = new StringBuilder();
                break;
            case ALLOWIMPORT:
                elementValue = new StringBuilder();
                break;
            case ALLOWEXPORT:
                elementValue = new StringBuilder();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case ID:
                userGroup.setId(Integer.parseInt(elementValue.toString()));
                break;
            case NAME:
                userGroup.setName(elementValue.toString());
                break;
            case DESCRIPTION:
                userGroup.setDescription(elementValue.toString());
                break;
            case ALLOWADD:
                userGroup.setAllowAdd(Boolean.parseBoolean(elementValue.toString()));
                break;
            case ALLOWEDIT:
                userGroup.setAllowEdit(Boolean.parseBoolean(elementValue.toString()));
                break;
            case ALLOWDELETE:
                userGroup.setAllowDelete(Boolean.parseBoolean(elementValue.toString()));
                break;
            case ALLOWPRINT:
                userGroup.setAllowPrint(Boolean.parseBoolean(elementValue.toString()));
                break;
            case ALLOWIMPORT:
                userGroup.setAllowImport(Boolean.parseBoolean(elementValue.toString()));
                break;
            case ALLOWEXPORT:
                userGroup.setAllowExport(Boolean.parseBoolean(elementValue.toString()));
                break;
        }
    }

    public UserGroup getUserGroup() {
        return this.userGroup;
    }
}

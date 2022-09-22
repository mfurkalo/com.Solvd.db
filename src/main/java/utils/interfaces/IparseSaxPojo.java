/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils.interfaces;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface IparseSaxPojo {

    <T extends DefaultHandler> T parceSax(String path, T handler) throws ParserConfigurationException, SAXException
            , IOException;

    boolean validate(String pathSchema, String pathXml);
}

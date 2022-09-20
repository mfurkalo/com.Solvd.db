/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package saxHandlers;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

interface IparseSaxPojo {

     DefaultHandler  parceSax(String path, DefaultHandler handler)throws ParserConfigurationException, SAXException, IOException;

     boolean validate(String pathSchema, String pathXml);
}

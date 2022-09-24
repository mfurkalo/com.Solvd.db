/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils.interfaces;

import org.xml.sax.helpers.DefaultHandler;

public interface IparseSaxPojo {

    <T extends DefaultHandler> T parse(String path, T handler);

    boolean validate(String pathSchema, String pathXml);
}

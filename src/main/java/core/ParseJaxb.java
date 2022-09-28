/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package core;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ParseJaxb {
    static Logger log = LogManager.getLogger(ParseJaxb.class.getName());
    String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    public <T> T parse(String path, java.lang.Class<?> T) {

        try {
            JAXBContext context = JAXBContext.newInstance(T);
            return (T) context.createUnmarshaller().unmarshal(new FileReader(path));
        } catch (JAXBException | FileNotFoundException e) {
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    public boolean validate(String pathSchema, String pathXml, java.lang.Class<?> T) {
        Schema schema;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        try {
            schema = schemaFactory.newSchema(new File(pathSchema));
        } catch (SAXException e) {
            log.log(Level.FATAL, e.getMessage(), e);
            throw new RuntimeException(e);
        }
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(T);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(schema);
            try {
                unmarshaller.unmarshal(new FileReader(pathXml));
            } catch (FileNotFoundException e) {
                log.log(Level.FATAL, e.getMessage(), e);
                throw new RuntimeException(e);
            }
        } catch (JAXBException e) {
            log.log(Level.FATAL, "The document failed to validate");
            log.log(Level.FATAL, e.getMessage(), e);
            return false;
        }
        return true;
    }
}

/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils;

import org.aeonbits.owner.ConfigFactory;
import utils.interfaces.IProperties;

public class Base {
    public static final IProperties properties = ConfigFactory.create(IProperties.class);
}

/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package utils.interfaces;

public interface IJacksonReadWrite {
    String unmarshal(Object object);

    <T> T marshall(String path, Class<?> T);
}

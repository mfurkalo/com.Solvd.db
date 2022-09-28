/*
 *  Copyright (c)
 *  Maksym Furkalo,
 *  work with DB using the DAO pattern,
 *  use for free
 */

package exeptions;

import java.sql.SQLException;

public class CustomSQLException extends SQLException {


    public CustomSQLException(String message) {
        super(message);

    }

    @Override
    public String toString() {
        return "Custom exception {"
                + "\n" + getMessage()
                + "} ";
    }
}

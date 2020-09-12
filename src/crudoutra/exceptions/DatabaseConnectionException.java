/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.exceptions;

import java.sql.SQLException;

public class DatabaseConnectionException extends SQLException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DatabaseConnectionException() 
    {
        super("Database Connection Error!");
    }
}    

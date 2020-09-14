/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.exceptions;

import java.sql.SQLException;

import crudoutra.config.Constant;

public class DatabaseConnectionException extends SQLException 
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DatabaseConnectionException(String errorMessage) 
    {
        super(errorMessage);
    }

    public DatabaseConnectionException() 
    {
        super(Constant.ERROR_DB_CONNECTION);
    }
}    

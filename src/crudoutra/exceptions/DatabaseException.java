/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.exceptions;

import java.sql.SQLException;

public class DatabaseException extends SQLException
{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    public DatabaseException() 
    {
        super("Database Error!");
    }
}    

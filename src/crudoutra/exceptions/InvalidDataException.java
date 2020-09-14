/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidDataException extends Exception 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidDataException(String errorMessage) 
    {
        super(errorMessage);
    }

    public InvalidDataException() 
    {
        super(Constant.ERROR_422);
    }
    
}

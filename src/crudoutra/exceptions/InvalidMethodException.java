/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidMethodException extends Exception 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidMethodException(String errorMessage) 
    {
        super(errorMessage);
    }

    public InvalidMethodException() 
    {
        super(Constant.ERROR_405);
    }
    
}

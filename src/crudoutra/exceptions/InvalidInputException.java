/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidInputException extends Exception 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidInputException(String errorMessage) 
    {
        super(errorMessage);
    }

    public InvalidInputException() 
    {
        super(Constant.ERROR_400);
    }
    
}

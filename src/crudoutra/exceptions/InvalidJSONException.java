/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidJSONException extends Exception 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidJSONException(String errorMessage) 
    {
        super(errorMessage);
    }

    public InvalidJSONException() 
    {
        super(Constant.ERROR_400);
    }
    
}

/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidAuthException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAuthException(String errorMessage) 
    {
        super(errorMessage);
    }

    public InvalidAuthException() 
    {
        super(Constant.ERROR_401);
    }
    
}

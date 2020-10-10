/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

 package crudoutra.exceptions;

import crudoutra.config.Constant;

public class InvalidAccessException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public InvalidAccessException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidAccessException() 
    {
        super(Constant.ERROR_403);
    }
    
}

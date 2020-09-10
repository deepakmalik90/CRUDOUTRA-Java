/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.config.Constant;

public class Validator
{
    HttpServletRequest httpServletRequest;
    HttpServletResponse httpServletResponse;

    public Validator(HttpServletRequest request, HttpServletResponse response) 
    {
        httpServletRequest  =   request;
        httpServletResponse =   response;
    }

    public void checkEmpty(String str)
    {
        if(str.isBlank())
            new Error(httpServletResponse).sendError(Constant.STATUS_422);
    }
  
}
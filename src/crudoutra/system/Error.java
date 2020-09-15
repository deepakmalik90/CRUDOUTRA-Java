/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import javax.servlet.http.HttpServletResponse;

import crudoutra.config.Constant;

public class Error extends crudoutra.config.Route 
{
    private  HttpServletResponse httpServletResponse;
    private Helper helper = new Helper();

    public Error(HttpServletResponse response) 
    {
        httpServletResponse =   response;
    }

    void sendError(Exception e, int status) 
    {
        httpServletResponse.setStatus(status);
        helper.setResponse(httpServletResponse, Constant.ERROR_RESPONSE.get(status));
        log(e);
    }

    void sendError(Exception e, int status, String customErrorMessage) 
    {
        httpServletResponse.setStatus(status);
        helper.setResponse(httpServletResponse, Constant.errorResponse(customErrorMessage));
        log(e);
    }

    /**
     *  Override this function to use your own log functionalty or third party library 
     */
    void log(Exception e)
    {
        e.printStackTrace();
    }
}


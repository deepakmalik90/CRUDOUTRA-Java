/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller 
{
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Helper helper = new Helper();

    public void init(HttpServletRequest request, HttpServletResponse response)   throws Exception 
    {
        httpServletRequest    =   request;
        httpServletResponse    =   response;
        setup(helper.parseRequest(httpServletResponse,httpServletRequest));
    }

    public void response(String response)
    {
        helper.setResponse(httpServletResponse, response);
    }

    public abstract void setup(Map<String, String> httpServletRequest) throws Exception ;
    public abstract void get()  throws Exception ; 
    public abstract void post() throws Exception ;
    public abstract void put() throws Exception;
    public abstract void delete() throws Exception;
}
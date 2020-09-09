package crudoutra.system;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Controller 
{
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private Helper helper = new Helper();

    public void init(HttpServletRequest request, HttpServletResponse response) 
    {
        httpServletRequest    =   request;
        httpServletResponse    =   response;
        setup(helper.parseRequest(request));
    }

    public void response(String response)
    {
        helper.setResponse(httpServletResponse, response);
    }

    public void error(int key)
    {
        new Error(httpServletRequest, httpServletResponse).sendError(key);
    }

    public void error(int key, String messgae)
    {
        new Error(httpServletRequest, httpServletResponse).sendError(key,messgae);
    }

    public abstract void setup(Map<String, String> httpServletRequest);
    public abstract void get();
    public abstract void post();
    public abstract void put();
    public abstract void delete();
}
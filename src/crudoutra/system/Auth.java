package crudoutra.system;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Auth 
{
    protected HttpServletRequest httpServletRequest;
    protected HttpServletResponse httpServletResponse;

    protected String path;
    protected String method;

    public void init(HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        httpServletRequest  =   request;
        httpServletResponse =   response;
        path                =   request.getServletPath();
        method              =   request.getMethod();
        this.check();
    }

    public abstract void check() throws Exception;
}

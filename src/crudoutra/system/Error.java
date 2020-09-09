package crudoutra.system;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error extends crudoutra.config.Route 
{
    public static final int STATUS_400 =   400;
    public static final int STATUS_403 =   403;
    public static final int STATUS_404 =   404;
    public static final int STATUS_405 =   405;
    public static final int STATUS_422 =   422;
    public static final int STATUS_500 =   500;

    private  HttpServletRequest httpServletRequest;
    private  HttpServletResponse httpServletResponse;

    private HashMap<Integer,String> errorHashMap    =   new HashMap<Integer,String>();
    private Helper helper = new Helper();

    public Error(HttpServletRequest request, HttpServletResponse response) 
    {
        httpServletRequest  =   request;
        httpServletResponse =   response;
        
        errorHashMap.put(STATUS_400, "{\"error\":\"Bad Request\"}");
        errorHashMap.put(STATUS_403, "{\"error\":\"Permission Denied\"}");
        errorHashMap.put(STATUS_404, "{\"error\":\"Invalid Path\"}");
        errorHashMap.put(STATUS_405, "{\"error\":\"Invalid Method\"}");
        errorHashMap.put(STATUS_422, "{\"error\":\"Invalid Data\"}");
        errorHashMap.put(STATUS_500, "{\"error\":\"Internal Server Error\"}");
    }

    void sendError(int key) 
    {
        httpServletResponse.setStatus(key);
        helper.setResponse(httpServletResponse, errorHashMap.get(key));
    }

    void sendError(int key,String customErrorMessage) 
    {
        httpServletResponse.setStatus(key);
        helper.setResponse(httpServletResponse, "{\"error\":\""+customErrorMessage+"\"}");
    }

    void logError() 
    {
        
    }

    void sendAndLogError()
    {
        
    }
}


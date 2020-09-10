/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import java.util.HashMap;
import javax.servlet.http.HttpServletResponse;

import crudoutra.config.Constant;

public class Error extends crudoutra.config.Route 
{
    private  HttpServletResponse httpServletResponse;

    private HashMap<Integer,String> errorHashMap    =   new HashMap<Integer,String>();
    private Helper helper = new Helper();

    public Error(HttpServletResponse response) 
    {
        httpServletResponse =   response;
        
        errorHashMap.put(Constant.STATUS_400, "{\"error\":\"Bad Request\"}");
        errorHashMap.put(Constant.STATUS_403, "{\"error\":\"Permission Denied\"}");
        errorHashMap.put(Constant.STATUS_404, "{\"error\":\"Invalid Path\"}");
        errorHashMap.put(Constant.STATUS_405, "{\"error\":\"Invalid Method\"}");
        errorHashMap.put(Constant.STATUS_422, "{\"error\":\"Invalid Data\"}");
        errorHashMap.put(Constant.STATUS_500, "{\"error\":\"Internal Server Error\"}");
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
}


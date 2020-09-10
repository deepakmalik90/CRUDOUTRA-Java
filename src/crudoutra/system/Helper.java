/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.config.Constant;

public class Helper extends HttpServlet
{
    static final long serialVersionUID  =   1L;

    public void setResponse(HttpServletResponse httpServletResponse, String message)
    {
        httpServletResponse.setContentType("application/json");
        PrintWriter pw = null;
        try 
        {
            pw = httpServletResponse.getWriter();
        } 
        catch (IOException e) 
        {
            new Error(httpServletResponse).sendError(Constant.STATUS_500);
        }
        pw.println(message);
        pw.flush();
        pw.close();
    }

    public Map<String, String> parseRequest(HttpServletResponse httpServletResponse, HttpServletRequest request)
    {
        Map<String, String> json = new HashMap<String, String>();
        try
        {
            String requestData   =   request.getReader().lines().collect(Collectors.joining());
            json                =   parseJSON(requestData);
        }
        catch (IOException e) 
        {
            new Error(httpServletResponse).sendError(Constant.STATUS_500);
        }
        catch (Exception e) 
        {
            new Error(httpServletResponse).sendError(Constant.STATUS_422);
        }
        return  json;
    }

    /**
     * I'm using a very simple logic to parse very basic JSONs
     * For example : {"name":"Joy","age":26}
     * if you want to parse complicated JSON then you can replace the logic
     * or use a third party library inside this function. 
     * 
     * @param str
     * @return
     * @throws Exception
     */

    public Map<String, String> parseJSON(String str) throws Exception
    {
        Map<String, String> json = new HashMap<String, String>();
        str         =   str.trim();
        str         =   str.replace("{","");
        str         =   str.trim();
        str         =   str.replace("}","");
        String[] arrOfStr   =   str.split(",", 0); 
        if(arrOfStr.length>1 || arrOfStr[0]!="")
        {
            for (String string : arrOfStr) 
            {
                string              =   string.trim();
                if(!string.isBlank())
                    json.put(string.split(":",0)[0].replaceAll("\"", "").trim(),string.split(":",0)[1].replaceAll("\"", "").trim());
            }
        }
        return json;
    }
}
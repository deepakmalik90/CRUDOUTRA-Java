package crudoutra.system;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Helper extends HttpServlet
{
    static final long serialVersionUID  =   1L;

    public void setResponse(HttpServletResponse response, String message)
    {
        response.setContentType("application/json");
        PrintWriter pw = null;
        try 
        {
            pw = response.getWriter();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        pw.println(message);
    }

    public Map<String, String> parseRequest(HttpServletRequest request)
    {
        String requestData;
        Map<String, String> json = new HashMap<String, String>();
        try 
        {
            requestData         =   request.getReader().lines().collect(Collectors.joining());
            requestData         =   requestData.trim();
            requestData         =   requestData.replace("{","");
            requestData         =   requestData.trim();
            requestData         =   requestData.replace("}","");
            String[] arrOfStr   =   requestData.split(",", 0); 
            if(arrOfStr.length>1 || arrOfStr[0]!="")
            {
                for (String string : arrOfStr) 
                {
                    string              =   string.trim();
                    if(!string.isBlank())
                        json.put(string.split(":",0)[0].replaceAll("\"", "").trim(),string.split(":",0)[1].replaceAll("\"", "").trim());
                }
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        };

        return json;
    }
}
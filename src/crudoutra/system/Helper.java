package crudoutra.system;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


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
}
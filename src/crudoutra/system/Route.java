package crudoutra.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.controllers.UserController;

public class Route
{
    private HttpServletRequest httpServletRequest;
    private HttpServletResponse httpServletResponse;

    private Controller controller;
    private String path;
    private String method;

    public Route(HttpServletRequest request, HttpServletResponse response)
    {
        httpServletRequest      =   request;
        httpServletResponse     =   response;
        path             =   request.getPathInfo();
        method           =   request.getMethod();
    }

    public void processRoute()
    {
        switch(path)
        {
            case "user" :
                controller     =   new UserController();
            break;

            default:
                System.out.println(path);
        }

        controller.init(httpServletRequest,httpServletResponse);
        processMethod(controller);
    }

    private <Genric extends Controller> void processMethod(Genric controller)
    {
        switch(method)
        {
            case "GET" :
                controller.get();
            break;
            case "POST" :
                controller.post();
            break;
            case "DELETE" :
                controller.delete();
            break;
            case "PUT" :
                controller.put();
            break;
            default:
                System.out.println(path);
        }
    }
}


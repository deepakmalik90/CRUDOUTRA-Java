package crudoutra.system;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Route extends RouteBase
{
    HashMap<String, String> routes = new HashMap<String, String>();
    
    public Route(HttpServletRequest request, HttpServletResponse response)
    {
        super(request, response);
        setRoutes();
        processRoute(routes);
    }

    void setRoutes()
    {
        routes.put("/user", "crudoutra.controllers.UserController");
    }
}


package crudoutra.config;

import java.util.HashMap;

public class Route 
{
    protected HashMap<String, String> routes = new HashMap<String, String>();

    protected void setRoutes()
    {
        routes.put("/user", "crudoutra.controllers.UserController");
    }
}


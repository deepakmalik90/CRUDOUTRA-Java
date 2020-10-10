/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.config;

import java.util.*;
import crudoutra.auth.*;

import crudoutra.system.RouteConfig;

public class Route 
{
    protected  List<RouteConfig> routes = new ArrayList<RouteConfig>();

    protected void setRoutes()
    { 
        routes.add(new RouteConfig("/user", "crudoutra.controllers.UserController", new Login()));
        routes.add(new RouteConfig("/login", "crudoutra.controllers.LoginController", new Default()));
    }
}


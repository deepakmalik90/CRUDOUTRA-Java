package crudoutra.system;

public class Auth 
{
    public static void authenticate(RouteConfig route)
    {
        if(!route.getIsPublic())
        {
            // Code to validate token
        }
    }    
}

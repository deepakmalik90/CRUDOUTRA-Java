package crudoutra.auth;

import crudoutra.system.Auth;
import crudoutra.exceptions.*;
import crudoutra.models.User;
import crudoutra.services.LoginService;

public class Login extends Auth 
{
    private User user;
    private LoginService loginService;

    @Override
    public void check() throws Exception 
    {
        user                =       new User();    
        loginService        =       new LoginService(user);

        String token        =   httpServletRequest.getHeader("token");

        user                =   loginService.verifyToken(token);
        
        if (user.getId().isBlank()) 
        {
            throw new InvalidDataException("Invalid Credentials");
        }
    }
}
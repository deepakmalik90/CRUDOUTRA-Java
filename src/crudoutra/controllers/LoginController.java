/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.controllers;

import crudoutra.system.Controller;

import java.util.Map;

import crudoutra.exceptions.*;
import crudoutra.services.*;
import crudoutra.models.*;

public class LoginController extends Controller
{
    private User user;
    private LoginService loginService;

    public void setup(Map<String, String> request) throws Exception 
    {
        user                =       new User();    

        if(!request.containsKey("username"))
            throw new InvalidDataException("Username is blank");
        else 
            user.setUserName(request.get("username"));
        
        if(!request.containsKey("password"))
            throw new InvalidDataException("password is blank");
        else 
            user.setPassword(request.get("password"));

        loginService    =   new LoginService(user);
    }

    public void post()  throws Exception
    {
        user = loginService.login();

        if (user.getId().isBlank()) 
        {
            throw new InvalidDataException("Invalid Credentials");
        }
        else 
        {
            String token = loginService.token();
            response(token);
        }
    }    

    public void get() throws Exception 
    {
        throw new InvalidMethodException();
    }

    public void put()  throws Exception
    {
        throw new InvalidMethodException();
    }

    public void delete() throws Exception
    {
        throw new InvalidMethodException();
    }
}
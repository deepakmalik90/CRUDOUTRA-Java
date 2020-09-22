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
    private String username;
    private String password;
    
    private LoginService loginService;
    private User user;


    public void setup(Map<String, String> request) throws Exception 
    {
        
        if(!request.containsKey("username"))
            throw new InvalidDataException("Username is blank");
        else 
            username = request.get("username");
        
        if(!request.containsKey("pssword"))
            throw new InvalidDataException("password is blank");
        else 
            password = request.get("password");

        loginService    =   new LoginService();
    }

    public void post()  throws Exception
    {
        user = loginService.login(username,password);

        if (user.getId()=="") 
        {
            throw new InvalidDataException("Invalid Credentials");
        }
        else 
        {
            String response =   String.valueOf(user.hashCode());
            response(response);
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
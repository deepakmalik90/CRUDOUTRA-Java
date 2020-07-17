package crudoutra.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.models.User;
import crudoutra.services.UserService;

public class UserController 
{
    private String content = "";

    public UserController(HttpServletRequest request, HttpServletResponse response)
    {
        UserService userService =   new UserService();
        String id  = request.getParameter("id");
        if(id==null)
        {
            ArrayList<User> users = userService.getAll(); 
            content =  users.toString();           
        }
        else 
        {
            User  user = userService.get(id);
            content = user.toString();           
        }
    }

    public String contents()
    {
        return content;
    }
}
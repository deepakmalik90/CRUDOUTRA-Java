package crudoutra.controllers;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.models.User;
import crudoutra.services.UserService;
import crudoutra.system.Helper;

public class UserController 
{
    private HttpServletResponse response;
    private User user = new User();    

    private Helper helper = new Helper();
    private UserService userService = new UserService();

    public UserController(HttpServletRequest req, HttpServletResponse res) 
    {
        response    =   res;
        Map<String, String[]> params      =   req.getParameterMap();
        
        if(params.containsKey("id"))
            user.setId(params.get("id")[0]);
        else     
            user.setId("");
        
        if(params.containsKey("age"))
            user.setAge(params.get("age")[0]);
        else     
            user.setAge("");
        
        if(params.containsKey("name"))
            user.setName(params.get("name")[0]);
        else     
            user.setName("");
    }

    public void get() 
    {
        if (user.getId()=="") 
        {
            ArrayList<User> users = userService.getAll();
            helper.setResponse(response, users.toString());
        } 
        else 
        {
            User u = userService.get(user.getId());
            helper.setResponse(response, u.toString());
        }
    }

    public void save()
    {
        userService.save(user);
        helper.setResponse(response, "Saved");
    }

    public void update()
    {
        userService.update(user);
        helper.setResponse(response, "Updated");
    }

    public void delete()
    {
        userService.delete(user);
        helper.setResponse(response, "Deleted");
    }
}
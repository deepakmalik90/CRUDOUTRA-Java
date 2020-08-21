package crudoutra.controllers;

import java.util.ArrayList;
import java.util.Map;

import crudoutra.models.User;
import crudoutra.services.UserService;
import crudoutra.system.Controller;

public class UserController extends Controller
{
    private User user               = new User();    
    private UserService userService = new UserService();

    public void setup(Map<String, String> request) 
    {
        if(request.containsKey("id"))
            user.setId(request.get("id"));
        else     
            user.setId("");
        
        if(request.containsKey("age"))
            user.setAge(request.get("age"));
        else     
            user.setAge("");
        
        if(request.containsKey("name"))
            user.setName(request.get("name"));
        else     
            user.setName("");
    }

    public void get() 
    {
        if (user.getId()=="") 
        {
            ArrayList<User> users = userService.getAll();
            response(users.toString());
        } 
        else 
        {
            User u = userService.get(user.getId());
            response(u.toString());
        }
    }

    public void post()
    {
        userService.save(user);
        response( "Saved");
    }

    public void put()
    {
        userService.update(user);
        response("Updated");
    }

    public void delete()
    {
        userService.delete(user);
        response("Deleted");
    }
}
/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.controllers;

import java.util.ArrayList;
import java.util.Map;

import crudoutra.models.User;
import crudoutra.services.UserService;
import crudoutra.system.Controller;

public class UserController extends Controller
{
    private User user;    
    private UserService userService;

    public void setup(Map<String, String> request) throws Exception 
    {
        user                =       new User();    
        userService         =       new UserService();

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

    public void get() throws Exception 
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

    public void post()  throws Exception
    {
        userService.update(user);
        response("Updated");
    }

    public void put()  throws Exception
    {
        userService.save(user);
        response( "Saved");
    }

    public void delete() throws Exception
    {
        userService.delete(user);
        response("Deleted");
    }
}
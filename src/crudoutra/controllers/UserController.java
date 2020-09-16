/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.controllers;

import java.util.ArrayList;
import java.util.Map;

import crudoutra.config.Constant;
import crudoutra.models.*;
import crudoutra.services.*;
import crudoutra.system.*;

public class UserController extends Controller
{
    private User user;    
    private UserService userService;

    public void setup(Map<String, String> request) throws Exception 
    {
        user                =       new User();    

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

        userService         =       new UserService(user);

    }

    public void get() throws Exception 
    {
        if (user.getId()=="") 
        {
            ArrayList<User> users = UserService.getAll();
            response(users.toString());
        } 
        else 
        {
            user = userService.get();
            response(user.toString());
        }
    }

    public void post()  throws Exception
    {
        user = userService.update();
        response(user.toString("User Updated!"));
    }

    public void put()  throws Exception
    {
        user = userService.save();
        response(user.toString("New User Saved!"));
    }

    public void delete() throws Exception
    {
        user = userService.delete();
        response(user.toString("User Deleted!"));
    }
}
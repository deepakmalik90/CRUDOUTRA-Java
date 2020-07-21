package crudoutra.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.models.User;
import crudoutra.services.UserService;
import crudoutra.system.Helper;

public class UserController 
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Helper helper = new Helper();
    private UserService userService =   new UserService();

    private String id;

    public UserController(HttpServletRequest req,HttpServletResponse res)
    {
        request     =   req;
        response    =   res;
    }

    public void get()
    {
        id          =   request.getParameter("id");
        if(id==null)
        {
            ArrayList<User> users = userService.getAll(); 
            helper.setResponse(response, users.toString());
        }
        else 
        {
            User  user = userService.get(id);
            helper.setResponse(response, user.toString());
        }
    }

    public void save()
    {
        userService.save(request);
        helper.setResponse(response, "Saved");
    }

    public void update()
    {
        userService.update(request);
        helper.setResponse(response, "Updated");
    }

    public void delete()
    {
        userService.delete(request);
        helper.setResponse(response, "Deleted");
    }
}
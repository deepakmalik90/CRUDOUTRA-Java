package crudoutra.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.controllers.UserController;

public class Route
{
    private UserController userController;

    public Route(HttpServletRequest request, HttpServletResponse response)
    {
        userController = new UserController(request,response);
    }

    public void processGet()
    {
        userController.get();
    }

    public void processPost()
    {
        userController.update();
    }

    public void processPut()
    {
        userController.save();
    }

    public void processDelete()
    {
        userController.delete();
    }
}


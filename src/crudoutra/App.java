package crudoutra;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import crudoutra.controllers.UserController;

@WebServlet("/")
public class App extends HttpServlet
{
    static final long serialVersionUID  =   1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new UserController(request,response).get();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new UserController(request,response).update();
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new UserController(request,response).save();
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new UserController(request,response).delete();
    }
}

// ToDo :-
// User get, add, update, remove
// Decoupled login system
// Permissions System
// Route System
// Proper error logs
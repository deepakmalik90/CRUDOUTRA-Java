package crudoutra;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import crudoutra.controllers.UserController;
import crudoutra.system.Helper;

@WebServlet("/")
public class App extends HttpServlet
{
    static final long serialVersionUID  =   1L;
    private Helper helper = new Helper();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String content = new UserController(request,response).contents();
        helper.setResponse(response, content);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String content = new UserController(request,response).contents();
        helper.setResponse(response, content);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String content = new UserController(request,response).contents();
        helper.setResponse(response, content);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        String content = new UserController(request,response).contents();
        helper.setResponse(response, content);
    }
}

// ToDo :-
// User get, add, update, remove
// Decoupled login system
// Permissions System
// Route System
// Proper error logs
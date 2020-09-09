package crudoutra;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import crudoutra.system.Route;

@WebServlet("/")
public class App extends HttpServlet
{
    static final long serialVersionUID  =   1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new Route(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new Route(request,response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new Route(request,response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException
    {
        new Route(request,response);
    }
}

// ToDo :-
// Decoupled login system
// Permissions System
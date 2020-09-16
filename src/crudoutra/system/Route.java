/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crudoutra.config.Constant;
import crudoutra.exceptions.*;

public class Route extends crudoutra.config.Route
{
    HttpServletRequest httpServletRequest;
    HttpServletResponse httpServletResponse;

    Controller controller;
    String path;
    String method;

    public Route(HttpServletRequest request, HttpServletResponse response) 
    {
        httpServletRequest  =   request;
        httpServletResponse =   response;
        path                =   request.getServletPath();
        method              =   request.getMethod();
        setRoutes();
        processRoute();
    }

    void processRoute() 
    {
        if (routes.containsKey(path)) 
        {
            try 
            {
                controller  =   (Controller) Class.forName(routes.get(path)).getDeclaredConstructor().newInstance();
                controller.init(httpServletRequest,httpServletResponse);
                processMethod(controller);
            }
            catch(InvalidMethodException e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_405);
            }
            catch(InvalidInputException e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_400);
            }
            catch(InvalidDataException e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_422,e.getMessage());
            }
            catch(DatabaseConnectionException e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_500,Constant.ERROR_DB_CONNECTION);
            }
            catch(DatabaseException e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_500,Constant.ERROR_DB);
            }
            catch (Exception e) 
            {
                new Error(httpServletResponse).sendError(e,Constant.STATUS_500);
            }
        }
        else 
        {
            new Error(httpServletResponse).sendError(new Exception(),Constant.STATUS_404);
        }
    }

    <Genric extends Controller> void processMethod(Genric controller) throws Exception
    {
        switch(method)
        {
            case "GET" :
                controller.get();
            break;
            case "POST" :
                controller.post();
            break;
            case "DELETE" :
                controller.delete();
            break;
            case "PUT" :
                controller.put();
            break;
            default:
                new Error(httpServletResponse).sendError(new Exception(),Constant.STATUS_405);
        }
    }
}


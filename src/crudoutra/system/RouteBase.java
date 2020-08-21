package crudoutra.system;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RouteBase {
    HttpServletRequest httpServletRequest;
    HttpServletResponse httpServletResponse;

    Controller controller;
    String path;
    String method;

    RouteBase(HttpServletRequest request, HttpServletResponse response) {
        httpServletRequest = request;
        httpServletResponse = response;
        path = request.getServletPath();
        method = request.getMethod();
    }

    void processRoute(HashMap<String, String> routes) {

        if (routes.containsKey(path)) {
            try {
                controller = (Controller) Class.forName(routes.get(path)).getDeclaredConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException
                    | ClassNotFoundException e) {
                e.printStackTrace();
            }
            controller.init(httpServletRequest,httpServletResponse);
            processMethod(controller);
        }
        else 
        {
            System.out.println(path);
        }
    }

    <Genric extends Controller> void processMethod(Genric controller)
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
                System.out.println(method);
        }
    }
}


package crudoutra.system;

public class RouteConfig 
{
    private String name;
    private String controllerPath;
    private Auth auth;

    public RouteConfig(String name, String controllerPath, Auth auth) 
    {
        this.name           =   name;
        this.controllerPath =   controllerPath;
        this.auth      =   auth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getControllerPath() {
        return controllerPath;
    }

    public void setControllerPath(String controllerPath) {
        this.controllerPath = controllerPath;
    }

    public Auth getAuth() {
        return auth;
    }

    public void setAuth(Auth auth) {
        this.auth = auth;
    }
    
}

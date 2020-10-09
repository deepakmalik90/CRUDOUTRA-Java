package crudoutra.system;

public class RouteConfig 
{
    private String name;
    private String controllerPath;
    private boolean isPublic;

    public RouteConfig(String name, String controllerPath, boolean isPublic) 
    {
        this.name           =   name;
        this.controllerPath =   controllerPath;
        this.isPublic      =   isPublic;
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

    public boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }
    
}

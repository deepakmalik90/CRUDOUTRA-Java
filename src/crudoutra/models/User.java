/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.models;

public class User
{
    private String id;
    private String username;
    private String password;

    public String getId()
    {
        return id;
    }

    public String getUserName()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setUserName(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String toString()
    {
        return "{\"id\":\""+getId()+"\",\"password\":\""+getPassword()+"\",\"username\":\""+getUserName()+"\"}";
    }

    public String toString(String customMessage)
    {
        return "[{\"id\":\""+getId()+"\",\"password\":\""+getPassword()+"\",\"username\":\""+getUserName()+"\"},{\"message\":\""+ customMessage+"\"}]";
    }

    
    public String token()
    {
        return "{\"token\":\""+hashCode()+"\"}";
    }
   
    public int hashCode() 
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    public boolean isEmpty()
    {
        if(id==null || id.isEmpty())
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}
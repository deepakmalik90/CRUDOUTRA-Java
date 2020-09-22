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
    private String name;
    private String username;
    private String email;
    private String password;
    private String age;

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getAge()
    {
        return age;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String toString()
    {
        return "{\"id\":\""+getId()+"\",\"age\":\""+getAge()+"\",\"name\":\""+getName()+"\"}";
    }

    public String toString(String customMessage)
    {
        return "[{\"id\":\""+getId()+"\",\"age\":\""+getAge()+"\",\"name\":\""+getName()+"\"},{\"message\":\""+ customMessage+"\"}]";
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
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
}
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
}
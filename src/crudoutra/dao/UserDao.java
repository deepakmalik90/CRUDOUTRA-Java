/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.dao;

import java.util.ArrayList;
import java.util.HashMap;

import crudoutra.system.*;
import crudoutra.models.*;

public class UserDao extends DataBaseAccess
{
    private User user;

    public UserDao(User user) throws Exception
    {
        super();
        this.user   = user;
    }

    public static ArrayList<User> getAll() throws  Exception
    {
        DataBaseAccess DB = new DataBaseAccess();
        ArrayList<User> users = new ArrayList<User>();
        DB.connect();
        Data   data   =  DB.query("SELECT * FROM users");

        for (HashMap<String,String> row : data.rows) 
        {
            User user = new User();
            user.setId(row.get("id"));
            user.setName(row.get("name"));
            user.setAge(row.get("age"));
            users.add(user);
        }

        DB.close();
        return users;
    }
    
    public User get() throws Exception
    {
        String id   =   user.getId();
        connect();
        Data   data   =   query("SELECT * FROM users WHERE \"id\"="+id);
        HashMap<String,String> row    =   data.row;
        
        user.setId(row.get("id"));
        user.setName(row.get("name"));
        user.setAge(row.get("age"));
        
        close();      
        return user;
    }

    public User save() throws  Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();

        connect();
        excute("INSERT INTO users(\"id\",\"name\",\"age\") values("+id+",'"+name+"',"+age+")");
        close();      

        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public User update() throws  Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();

        connect();
        excute("UPDATE users SET \"name\"='"+name+"', \"age\"="+age+" WHERE \"id\"="+id);
        close();      

        user.setName(name);
        user.setAge(age);
        return user;

    }

    public User delete() throws  Exception
    {
        String id   =   user.getId();
        
        connect();
        excute("DELETE FROM users WHERE \"id\"="+id);
        close();      

        return user;
    }

    public boolean exist() throws Exception
    {
        String id   =   user.getId();
        connect();
        Data   data   =   query("SELECT * FROM users WHERE \"id\"="+id);
        HashMap<String,String> row    =   data.row;
        
        if(row.containsKey("id") && !row.get("id").isBlank())
            return true;
        else 
            return false;    
        
    }
}
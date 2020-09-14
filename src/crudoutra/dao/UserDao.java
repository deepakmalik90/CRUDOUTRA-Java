/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.dao;

import java.util.ArrayList;
import java.util.HashMap;

import crudoutra.system.DB;
import crudoutra.system.Table;
import crudoutra.models.User;

public class UserDao extends DB
{
    public UserDao() throws Exception
    {
        super();
    }

    public ArrayList<User> getAll() throws  Exception
    {
        
        ArrayList<User> users = new ArrayList<User>();
        connect();
        Table   table   =  query("SELECT * FROM users");

        for (HashMap<String,String> row : table.rows) 
        {
            User user = new User();
            user.setId(row.get("id"));
            user.setName(row.get("name"));
            user.setAge(row.get("age"));
            users.add(user);
        }

        close();
        return users;
    }
    
    public User get(String id) throws Exception
    {
        User user = new User();
        connect();
        Table   table   =   query("SELECT * FROM users WHERE id="+id);
        HashMap<String,String> row    =   table.row;
        
        user.setId(row.get("id"));
        user.setName(row.get("name"));
        user.setAge(row.get("age"));
        
        close();      
        return user;
    }

    public void save(User user) throws  Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();
        connect();
        excute("INSERT INTO users(id,name,age) values("+id+",'"+name+"',"+age+")");
        close();      
    }

    public void update(User user) throws  Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();
        connect();
        excute("UPDATE users SET name='"+name+"', age="+age+" WHERE id="+id);
        close();      
    }

    public void delete(User user) throws  Exception
    {
        String id   =   user.getId();
        connect();
        excute("DELETE FROM users WHERE id="+id);
        close();      
    }
}
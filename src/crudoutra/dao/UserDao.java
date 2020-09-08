package crudoutra.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import crudoutra.system.DB;
import crudoutra.models.User;

public class UserDao extends DB
{
    public UserDao() throws Exception 
    {
        super();
    }

    public ArrayList<User> getAll() throws Exception
    {
        ArrayList<User> users = new ArrayList<User>();
        connect();
        ResultSet resultSet =  query("SELECT * FROM users");
        while (resultSet.next()) 
        {
            User user = new User();
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getString("age"));
            users.add(user);
        }
        close();
        return users;
    }
    
    public User get(String id) throws Exception
    {
        User user = new User();
        connect();
        ResultSet resultSet =  query("SELECT * FROM users WHERE id="+id);
        while (resultSet.next()) 
        {
            user.setId(resultSet.getString("id"));
            user.setName(resultSet.getString("name"));
            user.setAge(resultSet.getString("age"));
        }
        close();      
        return user;
    }

    public void save(User user) throws Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();
        connect();
        excute("INSERT INTO users(id,name,age) values("+id+",'"+name+"',"+age+")");
        close();      
    }

    public void update(User user) throws Exception
    {
        String id   =   user.getId();
        String name =   user.getName();
        String age  =   user.getAge();
        connect();
        excute("UPDATE users SET name='"+name+"', age="+age+" WHERE id="+id);
        close();      
    }

    public void delete(User user) throws Exception
    {
        String id   =   user.getId();
        connect();
        excute("DELETE FROM users WHERE id="+id);
        close();      
    }
}
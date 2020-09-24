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
        Data   data   =  DB.query("SELECT * FROM USERS");

        for (HashMap<String,String> row : data.rows) 
        {
            User user = new User();
            user.setId(row.get("ID"));
            user.setUserName(row.get("USERNAME"));
            user.setPassword(row.get("PASSWORD"));
            users.add(user);
        }

        DB.close();
        return users;
    }
    
    public User get() throws Exception
    {
        String id   =   user.getId();
        connect();
        Data   data   =   query("SELECT * FROM USERS WHERE ID="+id);
        HashMap<String,String> row    =   data.row;
        
        user.setId(row.get("ID"));
        user.setUserName(row.get("USERNAME"));
        user.setPassword(row.get("PASSWORD"));
        
        close();      
        return user;
    }

    public User save() throws  Exception
    {
        String username =   user.getUserName();
        String password  =   user.getPassword();

        connect();
        int id      =   excute("INSERT INTO USERS(NAME,PASSWORD) values('"+username+"',"+password+")");
        close();      

        user.setId(String.valueOf(id));
        user.setUserName(username);
        user.setPassword(password);
        return user;
    }

    public User update() throws  Exception
    {
        String id   =   user.getId();
        String username =   user.getUserName();
        String password  =   user.getPassword();

        connect();
        excute("UPDATE USERS SET USERNAME='"+username+"', PASSWORD="+password+" WHERE ID="+id);
        close();      

        user.setUserName(username);
        user.setPassword(password);
        return user;

    }

    public User delete() throws  Exception
    {
        String id   =   user.getId();
        
        connect();
        excute("DELETE FROM USERS WHERE ID="+id);
        close();      

        return user;
    }

    public boolean exist() throws Exception
    {
        String id   =   user.getId();
        connect();
        Data   data   =   query("SELECT * FROM USERS WHERE ID="+id);
        HashMap<String,String> row    =   data.row;
        
        if(row.containsKey("ID") && !row.get("ID").isBlank())
            return true;
        else 
            return false;    
        
    }
}
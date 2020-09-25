/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.dao;

import java.util.HashMap;

import crudoutra.system.*;
import crudoutra.exceptions.*;
import crudoutra.models.*;

public class LoginDao extends DataBaseAccess 
{
    private User user;

    public LoginDao(User user) throws DatabaseConnectionException 
    {
        super();
        this.user   = user;
    }

    public User get() throws Exception
    {
        String username     =   user.getUserName();
        String password     =   user.getPassword();

        connect();
        Data   data   =   query("SELECT * FROM USERS WHERE USERNAME='"+username +"' AND PASSWORD = '"+password+"'");
        HashMap<String,String> row    =   data.row;
        if(row.containsKey("id") && !row.get("id").isBlank())
        {
            user.setId(row.get("ID"));
            user.setUserName(row.get("USERNAME"));
            user.setPassword(row.get("PASSWORD"));
        }    
        close();      

        return user;
    }

    public String token() throws  Exception
    {
        String id       =   user.getId();
        String token    =   user.token();

        connect();
        excute("INSERT INTO AUTH(USER_ID,TOKEN) values('"+id+"','"+token+"')");
        close();      

        return token;
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
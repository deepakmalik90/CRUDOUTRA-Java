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
import crudoutra.exceptions.DatabaseConnectionException;
import crudoutra.models.*;

public class LoginDao extends DataBaseAccess 
{
    private User user = new User();

    public LoginDao() throws DatabaseConnectionException 
    {
        super();
    }

    public User get(String username, String password) throws Exception
    {

        connect();
        Data   data   =   query("SELECT * FROM users WHERE \"username\"="+username +" and \"password\" = "+password);
        HashMap<String,String> row    =   data.row;
        
        if(row.containsKey("id") && !row.get("id").isBlank())
        {
            user.setId(row.get("id"));
            user.setName(row.get("name"));
            user.setAge(row.get("age"));
        }    
    
        close();      

        return user;
    }

    
}
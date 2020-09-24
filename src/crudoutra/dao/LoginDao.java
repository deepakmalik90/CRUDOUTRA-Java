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
    private User user = new User();

    public LoginDao() throws DatabaseConnectionException 
    {
        super();
    }

    public User get(String username, String password) throws Exception
    {

        connect();
        Data   data   =   query("SELECT * FROM USERS WHERE USERNAME="+username +" and PASSWORD = "+password);
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

    
}
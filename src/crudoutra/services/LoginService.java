/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.services;

import crudoutra.exceptions.*;
import crudoutra.dao.*;
import crudoutra.models.*;

public class LoginService 
{
    private LoginDao loginDao;
    private User user;

    public User login(String username, String password)  throws Exception 
    {
        loginDao            = new LoginDao();

        if(username.isBlank())
            throw new InvalidDataException("Username is blank");
        else if(password.isBlank()) 
            throw new InvalidDataException("Password is blank");
        
        user            =  loginDao.get(username,password);

        return user;
    }

}
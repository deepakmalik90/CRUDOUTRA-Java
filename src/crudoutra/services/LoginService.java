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

    public LoginService(User user) throws Exception
    {
        this.user   = user;
        loginDao     = new LoginDao(user);
    }

    public User login()  throws Exception 
    {
        isValidData();
        user            =  loginDao.get();
        return user;
    }

    public String getToken()  throws Exception 
    {
        isValidUser();
        String  token            =  loginDao.genrateToken();
        return token;
    }

    public User verifyToken(String token)  throws Exception 
    {
        String userID            =  loginDao.verifyToken(token);
        user.setId(userID);
        user            =  loginDao.get();
        return user;
    }

    public void isValidUser()  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(!loginDao.exist())     
            throw new InvalidDataException("User does not exists");
    }

    public void isValidData()  throws Exception 
    {
        if(user.getPassword().isBlank())     
            throw new InvalidDataException("password is blank");
        else if(user.getUserName().isBlank())     
            throw new InvalidDataException("Username is blank");
    }

}
/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.services;

import java.util.ArrayList;

import crudoutra.exceptions.*;
import crudoutra.dao.*;
import crudoutra.models.*;

public class UserService 
{
    private UserDao userDao;
    private User user;
    
    public UserService(User user) throws Exception
    {
        this.user   = user;
        userDao     = new UserDao(user);
    }

    public static ArrayList<User> getAll()  throws Exception 
    {
        ArrayList<User> users = UserDao.getAll();
        return users;
    }

    public User get()  throws Exception 
    {
        isValidUser();
        return userDao.get();
    }

    public User save()  throws Exception 
    {
        isValidData();
        return userDao.save();
    }

    public User update()   throws Exception 
    {
        isValidUser();
        isValidData();
        return userDao.update();
    }

    public User delete()   throws Exception 
    {
        isValidUser();
        return userDao.delete();
    }

    public void isValidUser()  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(!userDao.exist())     
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
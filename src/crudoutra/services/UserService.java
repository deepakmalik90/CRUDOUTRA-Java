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
        return userDao.get();
    }

    public User save()  throws Exception 
    {
        isValidUpdateData();
        return userDao.save();
        
    }

    public User update()   throws Exception 
    {
        isValidCreateData();
        return userDao.update();
    }

    public User delete()   throws Exception 
    {
        isValidDeleteData();
        return userDao.delete();
    }

    public void isValidUpdateData()  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(!userDao.exist())     
            throw new InvalidDataException("User does not exists");
        else if(user.getAge().isBlank())     
            throw new InvalidDataException("User age is blank");
        else if(user.getName().isBlank())     
            throw new InvalidDataException("User name is blank");
    }

    public void isValidCreateData()  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(userDao.exist())     
            throw new InvalidDataException("User already exists");
        else if(user.getAge().isBlank())     
            throw new InvalidDataException("User age is blank");
        else if(user.getName().isBlank())     
            throw new InvalidDataException("User name is blank");
    }

    public void isValidDeleteData()  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(!userDao.exist())     
            throw new InvalidDataException("User does not exists");
    }
 
}
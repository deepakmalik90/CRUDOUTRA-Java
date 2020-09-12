/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.services;

import java.util.ArrayList;

import crudoutra.exceptions.*;
import crudoutra.dao.UserDao;
import crudoutra.models.User;

public class UserService 
{
    private UserDao userDao;

    public UserService() throws Exception
    {
        userDao = new UserDao();
    }

    public ArrayList<User> getAll()  throws Exception 
    {
        ArrayList<User> users = null;
        users = userDao.getAll();
        return users;
    }

    public User get(String id)   throws Exception 
    {
        User user = null;
        user = userDao.get(id);
        return user;
    }

    public boolean save(User user)  throws Exception 
    {
        isValidData(user);
        userDao.save(user);
        return true;
    }

    public boolean update(User user)   throws Exception 
    {
        isValidUser(user);
        userDao.update(user);
        return true;
    }

    public boolean delete(User user)   throws Exception 
    {
        isValidUser(user);
        userDao.delete(user);
        return true;
    }

    public void isValidUser(User user)  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(get(user.getId())==null)     
            throw new InvalidDataException("User does not exists");
    }

    public void isValidData(User user)  throws Exception 
    {
        if(user.getId().isBlank())
            throw new InvalidDataException("User Id is blank");
        else if(get(user.getId())!=null)     
            throw new InvalidDataException("User already exists");
        else if(user.getAge().isBlank())     
            throw new InvalidDataException("User age is blank");
        else if(user.getName().isBlank())     
            throw new InvalidDataException("User name is blank");
    }
 
}
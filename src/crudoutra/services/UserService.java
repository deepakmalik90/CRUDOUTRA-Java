/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.services;

import java.util.ArrayList;

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
        userDao.save(user);
        return true;
    }

    public boolean update(User user)   throws Exception 
    {
        userDao.update(user);
        return true;
    }

    public boolean delete(User user)   throws Exception 
    {
        userDao.delete(user);
        return true;
    }

    public boolean isValidId(String id)  throws Exception 
    {
        boolean response = false;
        return response;
    }
 
}
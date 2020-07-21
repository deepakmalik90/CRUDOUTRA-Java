package crudoutra.services;

import java.util.ArrayList;

import crudoutra.dao.UserDao;
import crudoutra.models.User;

import javax.servlet.http.HttpServletRequest;

public class UserService 
{
    private UserDao userDao;

    public UserService() 
    {
        try 
        {
            userDao = new UserDao();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getAll() 
    {
        ArrayList<User> users = null;
        try 
        {
            users = userDao.getAll();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return users;
    }

    public User get(String id) 
    {
        User user = null;
        try 
        {
            user = userDao.get(id);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return user;
    }

    public boolean save(HttpServletRequest request)
    {
        return true;
    }

    public boolean update(HttpServletRequest request)
    {
        return true;
    }

    public boolean delete(HttpServletRequest request)
    {
        return true;
    }
 
}
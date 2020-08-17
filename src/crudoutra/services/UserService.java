package crudoutra.services;

import java.util.ArrayList;

import crudoutra.dao.UserDao;
import crudoutra.models.User;

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

    public boolean save(User user)
    {
        try 
        {
            userDao.save(user);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean update(User user)
    {
        try 
        {
            userDao.update(user);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean delete(User user)
    {
        try 
        {
            userDao.delete(user);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return true;
    }
 
}
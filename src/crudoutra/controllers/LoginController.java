/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.controllers;

import crudoutra.system.Controller;

import java.util.Map;

import crudoutra.exceptions.*;
import crudoutra.services.*;
import crudoutra.system.Controller;


public class LoginController extends Controller
{
    private LoginService loginService;

    public void setup(Map<String, String> request) throws Exception 
    {
        loginService    =   new LoginService();
    }

    public void post()  throws Exception
    {
        loginService.login();
    }

    public void get() throws Exception 
    {
        throw new InvalidMethodException();
    }

    public void put()  throws Exception
    {
        throw new InvalidMethodException();
    }

    public void delete() throws Exception
    {
        throw new InvalidMethodException();
    }
}
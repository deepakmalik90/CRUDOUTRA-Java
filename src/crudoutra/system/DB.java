/*
 *   
 *   Author : Deepak Malik
 *   https://github.com/devmalik19/crudoutra-java
 *
 */

package crudoutra.system;

import java.io.InputStream;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import crudoutra.exceptions.*;

public class DB 
{
    private static String JDBC;
    private static String DB_URL;
    private static String USER;
    private static String PASS;
    private static Properties  dbProperties       =   new Properties();

    private Connection conn; 
    private Table table;
    private ResultSet resultSet;
    private Statement statement;



    public DB() throws DatabaseConnectionException
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream dbPropertiesInputStream = classLoader.getResourceAsStream("db.properties");

        try 
        {
            dbProperties.load(dbPropertiesInputStream);
        }
        catch(Exception e)
        {
            throw new DatabaseConnectionException();
        }

        JDBC        =   dbProperties.getProperty("JDBC");
        DB_URL      =   dbProperties.getProperty("DB_URL");
        USER        =   dbProperties.getProperty("USER");
        PASS        =   dbProperties.getProperty("PASS");
    }

    public void connect() throws DatabaseConnectionException
    {       
        try 
        {
            Class.forName(DB.JDBC);
            conn    =    DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASS); 
        }
        catch(Exception e)
        {
            throw new DatabaseConnectionException();
        } 
    }

    public void close() throws DatabaseConnectionException
    {
        try 
        {
            conn.close();
        }
        catch(Exception e)
        {
            throw new DatabaseConnectionException();
        }
    }

    public Table query(String query) throws DatabaseException
    {
        try 
        {
            statement   =   conn.createStatement();
            resultSet   =   statement.executeQuery(query);
            table       =   new Table(resultSet);
            return table;
        }
        catch(Exception e)
        {
            throw new DatabaseException();
        }
    }

    public int  excute(String query) throws DatabaseException
    {
        try 
        {
            statement   =   conn.createStatement();
            return statement.executeUpdate(query);
        }
        catch(Exception e)
        {
            throw new DatabaseException();
        }
    }
}
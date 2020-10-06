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

public class DataBaseAccess 
{
    private static String JDBC;
    private static String DB_URL;
    private static String USER;
    private static String PASS;
    private static Properties  dbProperties       =   new Properties();

    private Connection conn; 
    private Data data;
    private ResultSet resultSet;
    private Statement statement;



    public DataBaseAccess() throws DatabaseConnectionException
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
            Class.forName(DataBaseAccess.JDBC);
            conn    =    DriverManager.getConnection(DataBaseAccess.DB_URL, DataBaseAccess.USER, DataBaseAccess.PASS); 
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

    public Data query(String query) throws DatabaseException
    {
        try 
        {
            statement   =   conn.createStatement();
            resultSet   =   statement.executeQuery(query);
            data        =   new Data(resultSet);
            return data;
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
            statement           =   conn.createStatement();
            int affectedRows    =   statement.executeUpdate(query, new int[]{1});

            if(affectedRows ==0)
            {
                return 0;
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) 
            {
                return Integer.parseInt(generatedKeys.getString(1));
            }
            else  
                return 0;
        }
        catch(Exception e)
        {
            throw new DatabaseException();
        }
    }
}
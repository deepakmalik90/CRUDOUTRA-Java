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

public class DB 
{
    private static String JDBC;
    private static String DB_URL;
    private static String USER;
    private static String PASS;
    private static Properties  dbProperties       =   new Properties();

    private Connection conn; 

    public DB() throws Exception
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream dbPropertiesInputStream = classLoader.getResourceAsStream("db.properties");

        dbProperties.load(dbPropertiesInputStream);

        JDBC        =   dbProperties.getProperty("JDBC");
        DB_URL      =   dbProperties.getProperty("DB_URL");
        USER        =   dbProperties.getProperty("USER");
        PASS        =   dbProperties.getProperty("PASS");
    }

    public void connect() throws Exception
    {       
        Class.forName(DB.JDBC);
        conn    =    DriverManager.getConnection(DB.DB_URL, DB.USER, DB.PASS); 
    }

    public void close() throws Exception
    {
        conn.close();
    }

    public ResultSet query(String query) throws Exception
    {
        ResultSet resultSet = null;
        Statement statement = conn.createStatement();
        resultSet = statement.executeQuery(query);
        return resultSet;
    }

    public int  excute(String query) throws Exception
    {
        Statement statement = conn.createStatement();
        return statement.executeUpdate(query);
    }
   
}
package com.crm.Mobicentrum.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class is used to perform the database operations
 * @author JOLLU KISHORE
 *
 */
public class DataBaseUtility implements Iconstant{

	static Driver driver;
	static Connection connection;
	static ResultSet result;

	/**
	 * This method will establish  mysql database connection
	 * @throwsSQLException
	 */
	public void connectDB() throws SQLException {
		try 
		{
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(jdbcUrl,jdbcUN,jdbcPwd);
		} 
		catch (SQLException e)
		{
		}

	}
	/**
	 * This method will execute the select  querry
	 * @param query
	 * @return 
	 * @throwsThrowable
	 */
	public ResultSet executeQuery(String query) throws Throwable {	
		result = connection.createStatement().executeQuery(query);
		return result;		
	}

	/**
	 * This method will execute the  non select querry
	 * @param query
	 * @return
	 * @throwsThrowable
	 */
	public int executeUpdate(String query) throws Throwable {
		int result = connection.createStatement().executeUpdate(query);
		return result;
	}
	/**
	 * This method will close the mysql database
	 * @throwsSQLException
	 */
	public void closeDB() throws SQLException {
		try
		{
			connection.close();
		}	
	   catch (Exception e) 
	    {
		
	    }

	}
}


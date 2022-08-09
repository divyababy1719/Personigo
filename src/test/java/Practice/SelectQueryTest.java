package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
	public static void main(String args[]) throws SQLException
	{
		Connection con=null;
		try {
			//create object for jdbc driver
			Driver driverRef=new Driver();
			//load or register mysql database
			DriverManager.registerDriver(driverRef);
			//establish a connection with database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			//create statements(for writing querys)
			Statement stmt = con.createStatement();
			//execute the querys
			//stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('7', 'ramesh','gowda', 'r')");
			//stmt.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('8', 'mahesh','raj', 'm')");
			ResultSet qry = stmt.executeQuery("select * from students_info");
			//for printing the values
			while(qry.next())
			{
				System.out.println(qry.getInt(1)+"\t"+qry.getString(2)+"\t"+qry.getString(3)+"\t"+qry.getString(4));
			}
		}
		catch (Exception e) {
			System.out.println("Exception handled");
		}
		finally
		{
			System.out.println("close the connection");
			//close the connection 
			con.close();
		}

	}
}

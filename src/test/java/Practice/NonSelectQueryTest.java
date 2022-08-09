package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		int result=0;
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
			String qry = "insert into students_info(regno, firstname, middlename, lastname) values('8', 'rihan','roy', 'r')";
			result=stmt.executeUpdate(qry);
			//for printing the values
		}
		catch (Exception e) {
			System.out.println("Exception handled");
		}
		finally
		{
			if(result==1)
				System.out.println("row inserted successfully");
			else
				System.out.println("row not inserted");
			//close the connection 
			con.close();
		}

	}
}



package testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class ConnectMySql {
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","Rahmoune@72");//root=username,Rahmoune@72=password.
		
		System.out.println("Connected to MySQL DB");

		Statement stm=con.createStatement();
		ResultSet rs=stm.executeQuery("select * from seleniumuser");
		
		while (rs.next())
		{
	String firstName=rs.getString("firstname");
			System.out.println("DataBase recor is " + firstName);
		
	String email=rs.getString("email");
				System.out.println("DataBase recor is " + email);
		}
	}

}

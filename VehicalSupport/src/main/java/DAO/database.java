package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class database 
{
	public Connection con;
	public void connect()  
	{
		String user = "root";
		String pass = "casteil_143";
		String  url = "jdbc:mysql://localhost:3306/vehicalsupport";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pass);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}}
}

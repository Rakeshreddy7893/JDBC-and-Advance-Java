package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo01 {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/fsd57";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//type 4 driver
			
			Connection con = DriverManager.getConnection(url,"root","root");
			
			if (con != null) {
				System.out.println("Connection Established Successfully...");
			} else {
				System.out.println("Failed to Establish the Connection...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}

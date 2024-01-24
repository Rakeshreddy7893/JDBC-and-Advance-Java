package day01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//Update Employee Salary
public class demo6 {
	public static void main(String[] args) {

		Connection con = null;
		Statement stmt = null;

		System.out.println("Enter Employee Id and New Salary");
		Scanner scan = new Scanner(System.in);
		int empId = scan.nextInt();;
		double salary = scan.nextDouble();
		System.out.println();
		
		String url = "jdbc:mysql://localhost:3306/fsd57";
		
		String updateQuery = "update employee set salary = " + salary + " where empId = " + empId;
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");

			stmt = con.createStatement();
			int result = stmt.executeUpdate(updateQuery);

			if (result > 0) {
				System.out.println("Employee Record Updated");
			} else {
				System.out.println("Failed to Update the Employee Record!!!");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}



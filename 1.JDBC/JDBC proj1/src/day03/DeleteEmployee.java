package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class DeleteEmployee {
	
	public static void delete() {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = DbConnector.getConnector();
		FetchAllEmployee.printAllEmployee();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Employee id to delete :");
		int empid = sc.nextInt();
		
		String query = "delete from employee where empId = ?";
	    
		
		try {
			con = DbConnector.getConnector();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, empid);
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("employee record delted successfully !!");
				FetchAllEmployee.printAllEmployee();
			} else {
				System.out.println("Please enter a valid Employeeid ");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		delete();
	}

}

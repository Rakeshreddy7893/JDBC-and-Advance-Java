package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class UpdateEmployee {
	
	public static void update() {
		PreparedStatement pstmt = null;
		Connection con = null;
		con = DbConnector.getConnector();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee empname,emailId and empid to Update");
		String empname = sc.nextLine();
		String emailid = sc.next();
		int empid = sc.nextInt();
		
		String query = "update employee set empName = ? , emailId = ? where empId = ?";
	    
		
		try {
			con = DbConnector.getConnector();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, empname);
			pstmt.setString(2, emailid);
			pstmt.setInt(3, empid);
			GetEmployeeById.getEmployee(empid);
			
			System.out.println("==================================================================");
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("Employee Record Updated Successfully!!");
				GetEmployeeById.getEmployee(empid);
			} else {
				System.out.println("Update failed !!");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}


	public static void main(String[] args) {
		update();
	}

}
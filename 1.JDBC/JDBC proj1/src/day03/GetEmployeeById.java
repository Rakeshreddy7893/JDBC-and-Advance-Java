package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class GetEmployeeById {
    
    // Getting employee by id
    public static void getEmployee(int empid) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        con = DbConnector.getConnector();

        String query = "select * from employee where empId = ?";

        try {
            con = DbConnector.getConnector();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empid);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Employee details with id: " + empid);
                do {
                    System.out.print(rs.getInt(1) + "   ");
                    System.out.print(rs.getString(2) + "   ");
                    System.out.print(rs.getString(3) + "   ");
                    System.out.print(rs.getString(4) + "   ");
                    System.out.print(rs.getString(5) + "   ");
                    System.out.print(rs.getString(6) + "   ");
                   
                } while (rs.next());
            } else {
                System.out.println("No employee found with id: " + empid);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee id ");
        int empid = sc.nextInt();
        
        getEmployee(empid);
        sc.close();
    }
}

package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class GetEmployeeByName {
    
    // Getting employee by name
    public static void getEmployee() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        con = DbConnector.getConnector();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee empname");
        String empname = sc.nextLine();

        String query = "select * from employee where empName = ?";

        try {
            con = DbConnector.getConnector();
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, empname);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Employee details with name: " + empname);
                do {
                    System.out.print(rs.getInt(1) + "   ");
                    System.out.print(rs.getString(2) + "   ");
                    System.out.print(rs.getString(3) + "   ");
                    System.out.print(rs.getString(4) + "   ");
                    System.out.print(rs.getString(5) + "   ");
                    System.out.print(rs.getString(6) + "   ");
                    // Remove the line below since there is no column at index 7
                    // System.out.println(rs.getString(7));
                } while (rs.next());
            } else {
                System.out.println("No employee found with name: " + empname);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    public static void main(String[] args) {
        getEmployee();
    }
}

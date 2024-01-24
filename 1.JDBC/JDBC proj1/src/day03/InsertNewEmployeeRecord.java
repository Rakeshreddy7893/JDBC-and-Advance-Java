package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.DbConnector;

public class InsertNewEmployeeRecord {
    
    public static void insertRecordPrepareStatement() {
        PreparedStatement pstmt = null;
        Connection con = null;
        con = DbConnector.getConnector();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee empId, empname, salary, gender, emailId, password");
        int empid = sc.nextInt();
        sc.nextLine();
        String empname = sc.nextLine();
        String salary = sc.next(), gender = sc.next(), email = sc.next(), password = sc.next();
        
        String query = "INSERT INTO employee (empId, empname, salary, gender, emailId, password) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            con = DbConnector.getConnector();
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, empid);
            pstmt.setString(2, empname);
            pstmt.setString(3, salary);
            pstmt.setString(4, gender);
            pstmt.setString(5, email);
            pstmt.setString(6, password);
            int cnt = pstmt.executeUpdate();
            if (cnt > 0) {
                System.out.println("Employee Record inserted successfully !!");
                System.out.println("-----------------------------------------------------");
                // Assuming you have a method to print all employees
                FetchAllEmployee.printAllEmployee();
            } else {
                System.out.println("Employee Record not inserted successfully !!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
    
    public static void main(String[] args) {
        insertRecordPrepareStatement();
    }
}

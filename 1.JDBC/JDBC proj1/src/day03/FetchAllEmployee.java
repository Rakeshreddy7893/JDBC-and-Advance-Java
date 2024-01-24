package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DbConnector;

public class FetchAllEmployee {
    
    public static void printAllEmployee() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        
        try {
            con = DbConnector.getConnector();
            String query = "select * from employee";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            
            System.out.println("===========================================================");
            System.out.println("                   Employee Details");
            System.out.println("===========================================================");
            
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "   ");
                System.out.print(rs.getString(2) + "   ");
                System.out.print(rs.getString(3) + "   ");
                System.out.print(rs.getString(4) + "   ");
                System.out.print(rs.getString(5) + "   ");
                System.out.print(rs.getString(6) + "   ");
                System.out.println();  // Move to the next line for each employee
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

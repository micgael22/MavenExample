package jdbcConnection;

import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo {
    public static void main(String[] args) throws SQLException {
        //Creating the connection
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/jdbc_Database","root","thebigbangtheory05__");

        int rollNo = 2;
        String name_ = "Jane";
        int age = 22;
        String sql = "INSERT INTO student(rollNo, name_, age) " + "VALUES (" + rollNo + ",'" + name_ + "'," + age + ")";

        try {
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jdbc_Database","root","thebigbangtheory05__");

            Statement st = con.createStatement();
            int m =st.executeUpdate(sql);
            if (m == 1)
                System.out.println("Insert successfully : " + sql);
            else
                System.out.println("Insertion failed");
        }
        catch (Exception e) {
            System.err.println(e);
        }
        finally {
            con.close();
        }
    }
}











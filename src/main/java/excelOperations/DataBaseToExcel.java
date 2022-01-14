package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class DataBaseToExcel {

    public static void main(String[] args) throws SQLException, IOException {

       // String url = "jdbc:mysql://localhost:3306/world";
       // String user = "root";
       // String password = "thebigbangtheory05__";

        //Connect to the database
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/world","root","thebigbangtheory05__");

        //statement/query
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * from locations");

        //Excel
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Locations Data");

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("location_id");
        row.createCell(1).setCellValue("street_address");
        row.createCell(2).setCellValue("postal_code");
        row.createCell(3).setCellValue("city");
        row.createCell(4).setCellValue("state_province");
        row.createCell(5).setCellValue("country_id");

        int r = 1;

        while (rs.next())
        {
            int locID = rs.getInt("location_id");
            String streetAdd = rs.getString("street_address");
            String postalCode = rs.getString("postal_code");
            String city = rs.getString("city");
            String stateProv = rs.getString("state_province");
            String countryID = rs.getString("country_id");

            row = sheet.createRow(r++);

            row.createCell(0).setCellValue(locID);
            row.createCell(1).setCellValue(streetAdd);
            row.createCell(2).setCellValue(postalCode);
            row.createCell(3).setCellValue(city);
            row.createCell(4).setCellValue(stateProv);
            row.createCell(5).setCellValue(countryID);
        }
        FileOutputStream fos = new FileOutputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\locations.xlsx");
        workbook.write(fos);
        workbook.close();
        fos.close();
        con.close();

        System.out.println("Connected!!");

    }
}
//first we need to establish a connection with the database
// then we have to get the data from the table
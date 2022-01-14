package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExcelToDatabase  {
    public static void main(String[] args) throws SQLException, IOException {

        //Data connection
        Connection con = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/world", "root","thebigbangtheory05__");
        Statement stmt = con.createStatement();

        //create a new table in the database 'places'
        String sql = "CREATE TABLE places (location_ID decimal(4,0), street_address VARCHAR(40), postal_code VARCHAR(40), " +
                "city VARCHAR(40), state_province VARCHAR(40), country_ID VARCHAR(2))";
        stmt.execute(sql);

        //Excel
        FileInputStream fis = new FileInputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\locations.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Locations Data");

        int rows = sheet.getLastRowNum();

        for (int r = 1; r <= rows; r++) {
            XSSFRow row = sheet.getRow(r);
            double locID = row.getCell(0).getNumericCellValue();
            String streetAdd = row.getCell(1).getStringCellValue();
            String postalCode = row.getCell(2).getStringCellValue();
            String city = row.getCell(3).getStringCellValue();
            String stateProv = row.getCell(4).getStringCellValue();
            String countryID = row.getCell(5).getStringCellValue();

            sql = "INSERT INTO places VALUES ('"+locID+"', '"+streetAdd+"', '"+postalCode+"', '"+city+"', '"+stateProv+"', '"+countryID+"')";
            stmt.execute(sql);
            stmt.execute("COMMIT");
        }
        workbook.close();
        fis.close();
        con.close();

        System.out.println("DONE!!");
    }
}

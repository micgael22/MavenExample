package ExcelOperations2;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class WriteToExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("New data");

        Object employee [][] = {{"EmpID", "Name", "Job"},
                                {101, "David", "Engineer"},
                                {102, "Smith", "Manager"},
                                {103, "Scott", "Analyst"},
        };
        int rows = employee.length;
        int cols = employee[0].length;
        System.out.println(rows);
        System.out.println(cols);

        int rowCount = 0;
        for (Object emp [] : employee) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            for (Object value : emp) {
                Cell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }
        String filepath = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\employee.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filepath);
        workbook.write(outputStream);
        outputStream.close();

        System.out.println("Employee xlsx. file written successfully!!");
    }
}

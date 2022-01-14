package excelOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Workbook--> Sheet--> Rows--> Cells
public class WritingExcel {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Emp info");

        //will be able to hold all kind of data
        Object empdata[][] = {{"EmpID", "Name", "Job"},        //first Row  //header
                                {101, "David", "Engineer"},       //second row
                                {102, "Smith", "Manager"},        //third row
                                {103, "Scott", "Analyst"},        //forth row
        };

//__________Read the data from 2D Array__________//
        int rows = empdata.length;
        int cols = empdata[0].length;

        System.out.println(rows);           //returns 4 columns
        System.out.println(cols);           //returns 3 columns

/*  ---------------------------------------------------------------------------------------------------------
        for (int r = 0; r < rows; r++) {                     //representing the rows
            Row row = sheet.createRow(r);    //0        //creating a row in a sheet

            for (int c = 0; c < cols; c++) {                 //representing the columns ######## inside this row you create multiple cells by using inner for loop
                Cell cell = row.createCell(c);      //0        // cell is created in a row
                Object value = empdata[r][c];

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

 *///---------------------------------------------------------------------------
         //Using for ...each loop
        int rowCount = 0;

        for (Object emp [] : empdata) {                  // from that empdata(2D array) I'm reading it in emp[]
            Row row = sheet.createRow(rowCount++);      //create a row
            int columnCount = 0;                        //representing the cell number

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
        String filePath = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\employees.xlsx";
        FileOutputStream outStream = new FileOutputStream(filePath);            //open the stream because** to write the data in xlsx *Excel file
        workbook.write(outStream);                              //write the workbook into the file system

        outStream.close();                  //close that stream

        System.out.println("Employee.xlsx file written successfully!");
    }
}
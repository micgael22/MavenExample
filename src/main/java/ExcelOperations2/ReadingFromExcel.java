package ExcelOperations2;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingFromExcel {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\readformula1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.createSheet("Sheet 1");

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        //Iterator----------------------------------

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()){
            Row row = (Row) iterator.next();

            Iterator cellIterator =row.cellIterator();
            while (cellIterator.hasNext()){

                Cell cell = (Cell) cellIterator.next();

            switch (cell.getCellType())
                {
                    case STRING: System.out.print(cell.getStringCellValue());
                    break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue());
                    break;
                    case BOOLEAN: System.out.println(cell.getBooleanCellValue());
                    break;
                }
                System.out.println(" | ");
            }
            System.out.println();
        }
    }
}

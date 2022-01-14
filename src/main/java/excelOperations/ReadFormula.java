package excelOperations;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;

public class ReadFormula {
    public static void main(String[] args) throws IOException {
        Common Common = new Common();
        String filename = "readformula1.xlsx";
        String sheetname = "Sheet1";
        XSSFSheet sheet = Common.setWorkBook(filename, sheetname);
        //FileInputStream file = new FileInputStream(" C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\readformula1.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        Sheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(0).getLastCellNum();

        for (int r = 0; r<rows; r++) {  //0
           Row row = sheet.getRow(r);

           for (int c = 0; c <cols; c++) {  //0
               XSSFCell cell = (XSSFCell) row.getCell(c);

               switch (cell.getCellType())
               {
                   case STRING: System.out.print(cell.getStringCellValue());
                       break;
                   case NUMERIC: System.out.print(cell.getNumericCellValue());
                       break;
                   case BOOLEAN: System.out.print(cell.getBooleanCellValue());
                       break;
                   case FORMULA: System.out.println(cell.getNumericCellValue());
                       break;
               }
               System.out.print("|");
           }
            System.out.println();
        }
//        file.close();
        excelOperations.Common.closeWorkBook(filename);
    }
}

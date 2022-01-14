package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelToHashMap {
    public static void main(String[] args) throws IOException {
       Common Common = new Common();
        XSSFSheet sheet;
         String filename = "student.xlsx";
         String sheetname = "student data";
        sheet = Common.setWorkBook(filename, sheetname);
//        FileInputStream fis = new FileInputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\student.xlsx");
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheet("student data");
        int rows = sheet.getLastRowNum();

        Map <String, String> data = new HashMap <String, String>();

        //Reading data from excel to MashMap
        for (int r = 0; r < rows; r++) {
            String key = sheet.getRow(r).getCell(0).getStringCellValue();
            String value = sheet.getRow(r).getCell(1).getStringCellValue();
            data.put(key,value);
        }
        //Read data from hashMap
        for (Map.Entry entry : data.entrySet()) {       //entrySet = a collection of all key and value base
            System.out.println(entry.getKey() + "  " + entry.getValue());
        }
        excelOperations.Common.closeWorkBook(filename);
    }

}

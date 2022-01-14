package excelOperations;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapToExcel {

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Student data");

        Map <String, String > data = new HashMap<String, String>();
        data.put("101", "John");
        data.put("102", "Smith");
        data.put("103", "Scott");
        data.put("104", "Kim");
        data.put("105", "Mary");

        int rowNum = 0;

        for( Map.Entry entry : data.entrySet()) {
            XSSFRow row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue((String)entry.getKey());
            row.createCell(1).setCellValue((String)entry.getValue());
        }
        FileOutputStream fos = new FileOutputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\student.xlsx");

        workbook.write(fos);
        fos.close();
        System.out.println("Excel Written successfully");
    }
}

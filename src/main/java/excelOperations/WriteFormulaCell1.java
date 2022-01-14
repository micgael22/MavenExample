package excelOperations;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFormulaCell1 {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Numbers");
        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue(10);
        row.createCell(1).setCellValue(20);
        row.createCell(2).setCellValue(30);
        row.createCell(3).setCellFormula("A1*B1*C1");

        String filePath = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\writeFormula1.xlsx";
        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        fos.close();

        System.out.println("writeFormula.xlsx created with formula cell :)");
    }
}

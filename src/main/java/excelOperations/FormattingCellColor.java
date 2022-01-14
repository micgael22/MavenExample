package excelOperations;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FormattingCellColor {
    public static void main(String[] args) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");
        Row row = sheet.createRow(1);

        //---------------Setting background color-----------//
        XSSFCellStyle style = workbook.createCellStyle();

        style.setFillBackgroundColor(IndexedColors.BRIGHT_GREEN.getIndex());   //will return the index value
        style.setFillPattern(FillPatternType.SPARSE_DOTS);        //apply the index color to the cell

        Cell cell = row.createCell(1);
        cell.setCellValue("Welcome");
        cell.setCellStyle(style);           //_______Don't forget set style to cell_____

        //-------------Setting Foreground color------------//
        style = workbook.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell = row.createCell(2);
        cell.setCellValue("Automation");
        cell.setCellStyle(style);

        FileOutputStream fos = new FileOutputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\styles.xlsx"); // because we writing it to the xlsx file
        workbook.write(fos);
        workbook.close();
        fos.close();

        System.out.println("DONE !!");
    }
}

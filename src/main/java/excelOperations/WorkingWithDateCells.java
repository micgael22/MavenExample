package excelOperations;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class WorkingWithDateCells {

    public static void main(String[] args) throws IOException {

        // create workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //create blank sheet
        XSSFSheet sheet = workbook.createSheet("Date formats");

        //Date in number format
        XSSFCell cell = sheet.createRow(0).createCell(0);
        cell.setCellValue(new Date());

        XSSFCreationHelper creationHelper = workbook.getCreationHelper();

        //format1: dd-mm-yyyy
        CellStyle style1 = workbook.createCellStyle();
        style1.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy")); //specify date format

        XSSFCell cell1 = sheet.createRow(1).createCell(0);
        cell1.setCellValue(new Date());
        cell1.setCellStyle(style1);

        //format2: dd-mm-yyyy
        CellStyle style2 = workbook.createCellStyle();
        style1.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy")); //specify date format

        XSSFCell cell2 = sheet.createRow(2).createCell(0);
        cell2.setCellValue(new Date());
        cell2.setCellStyle(style2);

        //format3: dd-mm-yyyy hh:mm:ss
        CellStyle style3 = workbook.createCellStyle();
        style1.setDataFormat(creationHelper.createDataFormat().getFormat("dd-mm-yyyy hh:mm:ss")); //specify date format

        XSSFCell cell3 = sheet.createRow(3).createCell(0);
        cell3.setCellValue(new Date());
        cell3.setCellStyle(style3);

        //format4: dd-mm-yyyy hh:mm:ss
        CellStyle style4 = workbook.createCellStyle();
        style1.setDataFormat(creationHelper.createDataFormat().getFormat("hh:mm:ss")); //specify date format

        XSSFCell cell4 = sheet.createRow(4).createCell(0);
        cell4.setCellValue(new Date());
        cell4.setCellStyle(style4);

        FileOutputStream fos = new FileOutputStream("src/main/resources/dateFormats.xlsx");
        workbook.write(fos);
        workbook.close();
        fos.close();

        System.out.println("Done !!");

    }
}

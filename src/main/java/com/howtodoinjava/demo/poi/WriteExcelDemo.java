package com.howtodoinjava.demo.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelDemo {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet 1");

        Object infoData [][] = {{"Name", "Address"},
                                {"A001", "Addressx1"},
                                {"AOO2", "Adresssx2"},
                                {"A003", "Addressx3"},
                                {"A004", "Addressx4"}
        };
        int rows = infoData.length;
        int cols = infoData[0].length;

        System.out.println(rows); //5
        System.out.println(cols); //2

        int rowCount = 0;

        for (Object info [] : infoData) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            for (Object value : info) {
                Cell cell = row.createCell(columnCount++);

                if (value instanceof String)
                    cell.setCellValue((String) value);
                if (value instanceof Integer)
                    cell.setCellValue((Integer) value);
                if (value instanceof Boolean)
                    cell.setCellValue((Boolean) value);
            }
        }

        String filePath = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\information.xlsx";
        FileOutputStream outStream = new FileOutputStream(filePath);
        workbook.write(outStream);

        outStream.close();

        System.out.println("Employee.xlsx file written successfully!");
    }
}

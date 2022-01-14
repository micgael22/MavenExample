package com.howtodoinjava.demo.poi;

import org.apache.poi.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadExcelDemo {


    public static void main (String [] args) throws IOException {
        String fileName = "datasource.xlsx";
        String sheetName = "Sheet1";
        File file = new File("src/main/resources/"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        String fileExtension = fileName.substring(fileName.indexOf("."));
        Workbook wb = null;
        if(fileExtension.equals(".xlsx")){
             wb = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = wb.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
         for (int i = 0; i < rowCount +1; i++) {

             Row row = sheet.getRow(i);
             for (int j = 0; j < row.getLastCellNum(); j++){
                 System.out.print(row.getCell(j).getStringCellValue() + "|| ");
             }
         }
       System.out.println();

    }
}

package excelOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingExcel {
    public static void main(String[] args) throws IOException {

        Common Common = new Common();
        String filename = "readformula1.xlsx";
        String sheetname = "Sheet1";
        XSSFSheet sheet = Common.setWorkBook(filename, sheetname);

        /*//USING for loop to read the data from the sheet

        int rows = sheet.getLastRowNum();                       //number of rows
        int cols = sheet.getRow(1).getLastCellNum();          //number of columns

        for (int r = 0; r <= rows; r++){            //-----------representing the rows in excel----------\\
            Row row = sheet.getRow(r);                  //get the row**** this row will read all the cells

            for (int c = 0; c <cols; c++){          //----------- representing the cells in each row--------\\
                Cell cell = row.getCell(c);                     //this method will return the cell object

                switch (cell.getCellType())                             //it will return the type of the cell
                {
                    case STRING: System.out.print(cell.getStringCellValue());
                    break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue());
                    break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue());
                    break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }*/

        //____________Iterator_________
        Iterator iterator = sheet.iterator();           //it will return all the rows *iterator

        while (iterator.hasNext()){
           Row row = (Row) iterator.next();          // capture that all the cells we have to apply al the iterator for the cells

            Iterator cellIterator =row.cellIterator();                 // this will iterate all the cells OR it will capture all the cells and store them into one variable

            while (cellIterator.hasNext()){                             //check if the cell is present or not
                Cell cell = (Cell) cellIterator.next();                 //then it will come here and get the cell in this variable

                switch (cell.getCellType())                             //it will return the type of the cell
                {
                    case STRING: System.out.print(cell.getStringCellValue());
                        break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue());
                        break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue());
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }
}

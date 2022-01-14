package excelOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadingPasswordProtectedExcel {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\customer.xlsx");
        String password = "micgaeljulies";
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(fis, password);   //will create a workbook reference object
        Sheet sheet = workbook.getSheetAt(0);

        // -----------------read data from sheet Using iterator ---------------------

        Iterator <Row> iterator = sheet.iterator();                 //it will return all the rows *iterator
        while (iterator.hasNext()){                                 //hasNext will return a boolean
            Row row = (Row) iterator.next();                        // capture that all the cells we have to apply al the iterator for the cells

            Iterator <Cell> cellIterator =row.cellIterator();       //this will iterate all the cells OR it will capture all the cells and store them into one variable
            while (cellIterator.hasNext()){                         //will get the all the cells from the cells iterator
                Cell cell = (Cell) cellIterator.next();             //then it will come here and get the cell in this variable

                switch (cell.getCellType())                         //it will return the type of the cell
                {
                    case STRING: System.out.print(cell.getStringCellValue());      break;
                    case NUMERIC: System.out.print(cell.getNumericCellValue());    break;
                    case BOOLEAN: System.out.print(cell.getBooleanCellValue());    break;
                    case FORMULA: System.out.println(cell.getNumericCellValue());  break;
                }
                System.out.print(" | ");
            }
            System.out.println();
        }

        workbook.close();
        fis.close();
    }
}
/*       -----------------using for loop-------------

        int rows = sheet.getLastRowNum();
        System.out.println(rows);                                //5 = starting from 0
        int cols = sheet.getRow(1).getLastCellNum();          //number of columns
        System.out.println(cols);                               //3 = starting from 1



        for (int r = 0; r <= rows; r++){                          //-----------representing the rows in excel----------\\
            Row row = sheet.getRow(r);                            //get the row**** this row will read all the cells

            for (int c = 0; c <cols; c++){                        //----------- representing the cells in each row--------\\
                Cell cell = row.getCell(c);                       //this method will return the cell object

                switch (cell.getCellType())                       //it will return the type of the cell
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
                System.out.print(" | ");
            }
            System.out.println();
        }
        workbook.close();
        fis.close();
    }
}*/

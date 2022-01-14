package excelOperations;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Common{

    public static FileInputStream setFile(String filename) throws FileNotFoundException {
        String file = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\" + filename;
        FileInputStream fis = new FileInputStream(file);
        return fis;
    }

    public XSSFSheet setWorkBook(String filename, String sheetName) throws IOException {
        FileInputStream fis = this.setFile(filename);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        return sheet;
    }
    public static void closeWorkBook(String file) throws IOException {
        setFile(file).close();
    }
}

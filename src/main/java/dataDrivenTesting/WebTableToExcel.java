package dataDrivenTesting;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTableToExcel {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Micgael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

        String path="src\\main\\resources\\population.xlsx";
        XLUtility xlUtil = new XLUtility(path);

        //Write Headers in excel sheet
        xlUtil.setCellData("Sheet1", 0,0, "Country");
        xlUtil.setCellData("Sheet1", 0,1, "Populations");
        xlUtil.setCellData("Sheet1", 0,2, "% of the world");
        xlUtil.setCellData("Sheet1", 0,3, "Date");
        xlUtil.setCellData("Sheet1", 0,4, "Source");

        //capture table rows
        WebElement table = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",table);


        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr"));
        int rowsLength = rows.size();
        System.out.println(rowsLength);
        String stringTable = "//*[@id=\"mw-content-text\"]/div[1]/table/tbody/";
        String country = null;

        for (int r = 2; r < rowsLength; r++) {
            if(r == 136){
                country = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[" +r+"]/td[1]/span/a")).getText();

            }else{
                 country = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[" +r+"]/td[1]/a")).getText();

            }
            String population = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr["+r+"]/td[2]/a")).getText();
            String perOfWorld = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr["+r+"]/td[3]")).getText();
            String date = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr["+r+"]/td[4]")).getText();
            String source = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr["+r+"]/td[5]")).getText();

            System.out.println(country + population + perOfWorld + date + source);

            //writing the data in excel sheet
            xlUtil.setCellData("Sheet1", r, 0, country);
            xlUtil.setCellData("Sheet1", r, 1, population);
            xlUtil.setCellData("Sheet1", r, 2, perOfWorld);
            xlUtil.setCellData("Sheet1", r, 3, date);
            xlUtil.setCellData("Sheet1", r, 4, source);
        }
        System.out.println("Web scrapping is done successfully...");
        driver.close();
    }
}

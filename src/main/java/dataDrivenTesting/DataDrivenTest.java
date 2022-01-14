package dataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataDrivenTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Micgael\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test(dataProvider = "LoginData")
    public void loginTest(String user, String pwd, String exp){

        driver.get("https://admin-demo.nopcommerce.com/login");

        WebElement txtEmail = driver.findElement(By.id("Email"));
        txtEmail.clear();
        txtEmail.sendKeys(user);

        WebElement txtPassword = driver.findElement(By.id("Password"));
        txtPassword.clear();
        txtPassword.sendKeys(pwd);

        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]")).click(); //login button

        String exp_titles = "Dashboard / nopCommerce administration";
        String act_title = driver.getTitle();

        if(exp.equals("Valid"))
        {
            if(exp_titles.equals(act_title))
            {
                driver.findElement(By.linkText("Logout")).click();
            }
            else {
                Assert.assertTrue(true);
            }
        }
        else if (exp.equals("Invalid"))
        {
            if (exp_titles.equals(act_title)) {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);
            }
        }

        //System.out.println(user + pwd + exp);
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        /*String loginData[][]= {
                                {"admin@yourstore.com", "admin", "Valid"},
                                {"admin@yourstore.com", "adm", "Invalid"},
                                {"adm@yourstore.com", "admin", "Invalid"},
                                {"adm@yourstore.com", "adm", "Invalid"}
                                };
         */
        //get the data from excel
        String path = "C:\\User\\Micgael\\IdeaProjects\\MavenExample\\src\\main\\resources\\LoginData.xlsx";
        //span
        XLUtility xlUtil = new XLUtility(path);

        int totalRows = xlUtil.getRowCount("Sheet1");
        int totalCols = xlUtil.getCellCount("Sheet1", 1);

        String loginData[][] = new String[totalRows][totalCols];

        for (int i = 1; i <= totalRows; i++)
        {
            for (int j=0; j<totalCols; j++){
                loginData[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}

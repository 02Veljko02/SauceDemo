package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

public class BaseTest1 {
    private WebDriver driver;
    protected LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.backToLoginPage();
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void backToLoginPage(){
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }
    @AfterClass
    public void turnOff(){
        driver.quit();
    }
}

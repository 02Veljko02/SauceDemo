package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

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

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
    private File screenshotPath;

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
    public void takeScreenshot(ITestResult result){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        screenshotPath = new File("C:\\Users\\Informatika\\IdeaProjects\\saucedemo\\src\\main\\resources\\screenshots\\" + result.getName() + ".png");
        try {
            Files.move(screenshot, screenshotPath);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    @AfterMethod
    public void insertScreenshotInReport(ITestResult result){
        Reporter.setCurrentTestResult(result);
        if (!result.isSuccess()){
            takeScreenshot(result);
            Reporter.log(result.getName() + "has failed");
            Reporter.log("<a target= _blank href=" + screenshotPath + "height='400 width='400'>screenshoot</a>");
        } else if (result.isNotRunning()) {
            Reporter.log(result.getName() + "was skiped");
        } else {
            Reporter.log(result.getName() + "Was passed");
        }
    }
    @AfterClass
    public void turnOff(){
        driver.quit();
    }


}

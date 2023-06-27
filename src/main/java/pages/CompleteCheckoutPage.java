package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteCheckoutPage {
    private WebDriver driver;
    private By backHomeButton = By.id("back-to-products");
    private By finishText = By.className("complete-header");

    public CompleteCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public HomePage clickBackHome(){
        driver.findElement(backHomeButton).click();
        return new HomePage(driver);
    }
    public String getFinishShoppingText(){
        return driver.findElement(finishText).getText();
    }

}

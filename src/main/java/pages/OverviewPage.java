package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
    private WebDriver driver;
    private By itemTotal = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");

    public OverviewPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getItemTotal(){
        return driver.findElement(itemTotal).getText();
    }
    public CompleteCheckoutPage clickFinish(){
        driver.findElement(finishButton).click();
        return new CompleteCheckoutPage(driver);
    }
}

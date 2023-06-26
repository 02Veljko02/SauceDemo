package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodefield = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setPostalCode(String postalCode){
        driver.findElement(postalCodefield).sendKeys(postalCode);
    }
    public OverviewPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new OverviewPage(driver);
    }
}

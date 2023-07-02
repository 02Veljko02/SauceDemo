package pages;

import org.asynchttpclient.webdav.WebDavCompletionHandlerBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;
    private By remove = By.className("btn_small");
    private By checkout = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public int countItems(){
        return driver.findElements(remove).size();
    }
    public void clickRemoveByIndex(int index){
        List<WebElement> button = driver.findElements(remove);
        button.get(index).click();
    }
    public CheckoutPage clickCheckoutButton(){
        driver.findElement(checkout).click();
        return new CheckoutPage(driver);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {private WebDriver driver;
    private By title = By.className("title");
    private By cart = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public ProductPage clickProductPage(String productPage){
        driver.findElement(By.linkText(productPage)).click();
        return new ProductPage(driver);
    }
    public String getTitle(){
        return driver.findElement(title).getText();
    }
    public CartPage clickCart(){
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
    public void clickAddToCartFromHomePageByIndex(int index){
        List<WebElement> buttons = driver.findElements(By.className("btn_small"));
        buttons.get(index).click();
    }
    public void clickRemoveFromHomePage(int index){
        List<WebElement> buttons = driver.findElements(By.className("btn_small"));
        buttons.get(index).click();
    }


}

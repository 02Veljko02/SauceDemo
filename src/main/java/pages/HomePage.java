package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
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
}

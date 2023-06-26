package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.tagName("button");
    private By backToProducts = By.id("back-to-products");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickAddToCartButton(){
        driver.findElement(addToCartButton).click();
    }
    public HomePage clickBackToProducts(){
        driver.findElement(backToProducts).click();
        return new HomePage(driver);
    }
}

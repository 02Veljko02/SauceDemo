package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.className("btn_primary");
    private By backToProducts = By.id("back-to-products");
    private By cart = By.className("shopping_cart_link");
    private By productName = By.className("inventory_details_name");

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
    public CartPage clickCart(){
        driver.findElement(cart).click();
        return new CartPage(driver);
    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}

package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartTest extends BaseTest1 {
    @Test
    public void countItemsTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage =homePage.clickProductPage("Sauce Labs Backpack");
        productPage.clickAddToCartButton();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Bike Light");
        productPage.clickAddToCartButton();
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 2, "Not expected number of items");
    }
    @Test
    public void countItemsTest2(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(3);
        homePage.clickAddToCartFromHomePageByIndex(4);
        homePage.clickAddToCartFromHomePageByIndex(5);
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickAddToCartFromHomePageByIndex(1);
        homePage.clickAddToCartFromHomePageByIndex(2);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 6, "Not expected number of items");
    }


}

package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest1 {
    @Test
    public void countItemsTest() {
        loginPage.setUsername("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage = homePage.clickProductPage("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Bike Light");
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 2, "Not true number of items");
    }

    @Test
    public void countItemsTestAddedFromHomePage() {
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
    @Test
    public void countItemsTestAddedFromHomePageForProblemUser() {
        loginPage.setUsername("problem_user");
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

    @Test
    public void checkProducts() {
        loginPage.setUsername("problem_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage = homePage.clickProductPage("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Bike Light");
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 2, "Not expected number of items");
    }
}
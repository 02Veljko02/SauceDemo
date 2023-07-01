package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class AddToCartFromProductPageTests extends BaseTest1 {
    @Test
    public void addOneItemTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage = homePage.clickProductPage("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 1, "Not true number of items");
    }
    @Test
    public void addSixItemsTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage = homePage.clickProductPage("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Bike Light");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Bike Light", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Bolt T-Shirt", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Fleece Jacket");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Fleece Jacket", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Sauce Labs Onesie");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Onesie", "Not true product name");
        productPage.clickAddToCart();
        homePage = productPage.clickBackToProducts();
        productPage = homePage.clickProductPage("Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(productPage.getProductName(), "Test.allTheThings() T-Shirt (Red)", "Not true product name");
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 6, "Not true number of items");
    }
}

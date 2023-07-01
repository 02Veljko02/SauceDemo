package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class RemoveFromCartPageTests extends BaseTest1 {
    @Test
    public void removeFromCartPageTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        ProductPage productPage = homePage.clickProductPage("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getProductName(), "Sauce Labs Backpack", "Not true product name");
        productPage.clickAddToCart();
        CartPage cartPage = productPage.clickCart();
        cartPage.clickRemoveByIndex(0);
        Assert.assertEquals(cartPage.countItems(), 0, "Not expected number of items");
    }
    @Test
    public void removeSixItemsFromCartPageTest() {
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
        cartPage.clickRemoveByIndex(5);
        cartPage.clickRemoveByIndex(4);
        cartPage.clickRemoveByIndex(3);
        cartPage.clickRemoveByIndex(2);
        cartPage.clickRemoveByIndex(1);
        cartPage.clickRemoveByIndex(0);
        Assert.assertEquals(cartPage.countItems(), 0, "Not true number of items");
    }
}

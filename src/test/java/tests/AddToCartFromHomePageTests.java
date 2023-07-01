package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddToCartFromHomePageTests extends BaseTest1 {
    @Test
    public void addOneItemTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 1, "Not true number of items");
    }
    @Test
    public void addSixItemsTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickAddToCartFromHomePageByIndex(1);
        homePage.clickAddToCartFromHomePageByIndex(2);
        homePage.clickAddToCartFromHomePageByIndex(3);
        homePage.clickAddToCartFromHomePageByIndex(4);
        homePage.clickAddToCartFromHomePageByIndex(5);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 6, "Not expected number of items");
    }
}

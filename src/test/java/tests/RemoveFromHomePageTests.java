package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class RemoveFromHomePageTests extends BaseTest1 {
    @Test
    public void removeFromHomePageTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickRemoveFromHomePageByIndex(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
    }
    @Test
    public void removeSixItemsFromHomePageTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickAddToCartFromHomePageByIndex(1);
        homePage.clickAddToCartFromHomePageByIndex(2);
        homePage.clickAddToCartFromHomePageByIndex(3);
        homePage.clickAddToCartFromHomePageByIndex(4);
        homePage.clickAddToCartFromHomePageByIndex(5);
        homePage.clickRemoveFromHomePageByIndex(0);
        homePage.clickRemoveFromHomePageByIndex(1);
        homePage.clickRemoveFromHomePageByIndex(2);
        homePage.clickRemoveFromHomePageByIndex(3);
        homePage.clickRemoveFromHomePageByIndex(4);
        homePage.clickRemoveFromHomePageByIndex(5);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
    }
}

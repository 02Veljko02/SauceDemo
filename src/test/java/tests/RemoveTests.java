package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class RemoveTests extends BaseTest1 {
    @Test
    public void removeFromHomePageTest(){
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickRemoveFromHomePageByIndex(0);
        Assert.assertEquals(homePage.countRemoveButtons(), 0, "Not expected number");
    }
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
}

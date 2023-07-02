package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.DataUtil;

import java.util.HashMap;

public class RemoveTests extends BaseTest1 {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void removeFromHomePageTest(HashMap<String, String> hashMap){
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        CartPage cartPage = homePage.clickCart();
        cartPage.clickRemoveByIndex(0);
        Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void removeSixItemsFromHomePageTest(HashMap<String, String> hashMap){
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickAddToCartFromHomePageByIndex(1);
        homePage.clickAddToCartFromHomePageByIndex(2);
        homePage.clickAddToCartFromHomePageByIndex(3);
        homePage.clickAddToCartFromHomePageByIndex(4);
        homePage.clickAddToCartFromHomePageByIndex(5);
        CartPage cartPage = homePage.clickCart();
        cartPage.clickRemoveByIndex(5);
        cartPage.clickRemoveByIndex(4);
        cartPage.clickRemoveByIndex(3);
        cartPage.clickRemoveByIndex(2);
        cartPage.clickRemoveByIndex(1);
        cartPage.clickRemoveByIndex(0);
        Assert.assertEquals(cartPage.countItems(), 0, "Not expected number");
    }
}

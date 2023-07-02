package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import utils.DataUtil;

import java.util.HashMap;

public class AddToCartTests extends BaseTest1 {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void addOneItemTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 1, "Not true number of items");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void addSixItemsTest(HashMap<String, String> hashMap) {
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
        Assert.assertEquals(cartPage.countItems(), 6, "Not expected number of items");
    }
}

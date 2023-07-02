package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OverviewPage;
import utils.DataUtil;

import java.util.HashMap;

public class TotalPriceTest extends BaseTest1 {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void getItemTotalTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 1, "Not expected number");
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.setFirstName("Veljko");
        checkoutPage.setLastName("Jovkovic");
        checkoutPage.setPostalCode("37230");
        OverviewPage overviewPage = checkoutPage.clickContinueButton();
        Assert.assertEquals(overviewPage.getItemTotal(), "Item total: $29.99", "Not expected price");

    }
}
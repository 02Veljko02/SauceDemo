package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.OverviewPage;

public class TotalPriceTest extends BaseTest1 {
    @Test
    public void getItemTotalTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        homePage.clickAddToCartFromHomePageByIndex(0);
        homePage.clickAddToCartFromHomePageByIndex(1);
        CartPage cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.countItems(), 2, "Not expected number");
        CheckoutPage checkoutPage = cartPage.clickCheckoutButton();
        checkoutPage.setFirstName("Veljko");
        checkoutPage.setLastName("Jovkovic");
        checkoutPage.setPostalCode("37230");
        OverviewPage overviewPage = checkoutPage.clickContinueButton();
        Assert.assertEquals(overviewPage.getItemTotal(), "Item total: $39.98", "Not expected price");

    }
}
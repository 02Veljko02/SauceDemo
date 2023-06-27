package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataUtil;

import java.util.HashMap;

public class DataProviderLoginTests extends BaseTest1 {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void loginWithDataProvider(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void loginWithDataProvider2(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider3")
    public void loginWithDataProvider3(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Login is successfull");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider4")
    public void loginWithDataProvider4(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider5")
    public void loginWithDataProvider5(HashMap<String, String> hashMap){
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Not expected message");
    }
}

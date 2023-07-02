package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataUtil;

import java.util.HashMap;

public class DataProviderLoginTests extends BaseTest1 {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void standardUserLoginTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void problemUserLoginTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider3")
    public void lockedUsedLoginTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Login is successfull");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider4")
    public void performanceGlitchUserLoginTest(HashMap<String, String> hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider5")
    public void loginWithWrongUsernameTest(HashMap<String, String> hashMap){
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Not expected message");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider6")
    public void LoginWithWrongPasswordTest(HashMap<String, String > hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider7")
    public void loginJustWithUsernameTest(HashMap<String, String > hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider8")
    public void loginJustWithPasswordTest(HashMap<String, String > hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider9")
    public void loginWithoutUsernameandPasswordTest(HashMap<String, String > hashMap) {
        loginPage.setUsername(hashMap.get("username"));
        loginPage.setPassword(hashMap.get("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
}

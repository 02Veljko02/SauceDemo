package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest1 {
    @Test
    public void standardUserLoginTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void problemUserLoginTest() {
        loginPage.setUsername("problem_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void lockedUsedLoginTest() {
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is login successfully");
    }

    @Test
    public void performanceGlitchUserLoginTest() {
        loginPage.setUsername("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }
    @Test
    public void loginWithWrongUsernameTest() {
        loginPage.setUsername("veljko");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void LoginWithWrongPasswordTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("veljko");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void loginJustWithUsernameTest() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test
    public void loginJustWithPasswordTest() {
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
    @Test
    public void loginWithoutUsernameandPasswordTest() {
        loginPage.setUsername("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
}


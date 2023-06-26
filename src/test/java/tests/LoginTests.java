package tests;

import base.BaseTest1;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest1 {
    @Test
    public void standardUserLogin() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void unsuccessfullLogin1() {
        loginPage.setUsername("veljko");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void unsuccessfullLogin2() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("Veljko");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }

    @Test
    public void problemUserLogin() {
        loginPage.setUsername("problem_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void lockedUsedLogin() {
        loginPage.setUsername("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is login successfully");
    }

    @Test
    public void performanceGlitchUserLogin() {
        loginPage.setUsername("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        HomePage homePage = loginPage.clickLoginButton();
        Assert.assertEquals(homePage.getTitle(), "Products", "Not expected");
    }

    @Test
    public void loginJustWithUsername() {
        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test
    public void loginJustWithPassword() {
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
}


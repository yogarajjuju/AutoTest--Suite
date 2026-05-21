package com.autotest.tests;

import com.autotest.pages.LoginPage;
import com.autotest.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Valid login should redirect to inventory page")
    public void testValidLogin() {
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.getCurrentUrl().contains("inventory"),
            "Login failed - not redirected to inventory page");
    }

    @Test(priority = 2, description = "Invalid login should show error message")
    public void testInvalidLogin() {
        loginPage.open();
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username and password do not match any user"),
            "Expected error message not shown, got: " + error);
    }

    @Test(priority = 3, description = "Empty credentials should show error")
    public void testEmptyCredentials() {
        loginPage.open();
        loginPage.clickLogin();
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Username is required"),
            "Expected empty credentials error, got: " + error);
    }

    @AfterClass
    public void teardown() {
        DriverManager.quitDriver();
    }
}

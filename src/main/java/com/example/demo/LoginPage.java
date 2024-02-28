package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class LoginPage extends AbstractPage {
    public static WebElement element = null;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void fillUserName(WebDriver driver, String username) {
        element = driver.findElement(By.id("login"));
        element.sendKeys(username);
    }

    public static void fillPassword(WebDriver driver, String Password) {
        element = driver.findElement(By.id("password"));
        element.sendKeys(Password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(By.id("submit")).click();
    }

    public static void verifyLogin(WebDriver driver) {
        element = driver.findElement(By.id("logout"));
        Reporter.log("Login with valid credentials is successful", true);
    }


    public static void loginToExpenseTracker(WebDriver driver, String username, String password) {
        fillUserName(driver, username);
        fillPassword(driver, password);
        clickLoginButton(driver);
        verifyLogin(driver);
    }
}

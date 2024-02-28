package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;


public class RegistrationPage {
    public static WebElement element = null;

    public static void newUserRegistrationLink(WebDriver driver) {
        element = driver.findElement(By.xpath("//a[@href='register.jsp']"));
        element.click();
    }

    public static void fillUserName(WebDriver driver, String username) {
        element = driver.findElement(By.id("login"));
        element.sendKeys(username);
    }

    public static void fillPassword(WebDriver driver, String Password) {
        element = driver.findElement(By.id("password1"));
        element.sendKeys(Password);
    }

    public static void repeatPassword(WebDriver driver, String Password) {
        element = driver.findElement(By.id("password2"));
        element.sendKeys(Password);
    }

    public static void clickLogin(WebDriver driver) {
        element = driver.findElement(By.id("submit"));
        element.click();
    }

    public static void verifyRegistration(WebDriver driver) {
        element = driver.findElement(By.id("logout"));
        Reporter.log("Log out button found with id, New user registration is successful", true);

    }


    public static void newUserRegistration(WebDriver driver, String username, String password1, String password2) {
        newUserRegistrationLink(driver);
        fillUserName(driver, username);
        fillPassword(driver, password1);
        repeatPassword(driver, password2);
        clickLogin(driver);
        verifyRegistration(driver);
    }
}

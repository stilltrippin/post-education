package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    private WebDriver driver;
    private HomePage homepage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("twitter.com");
        homepage = new Homepage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNavigationToHomepage() {
        Assert.assertTrue(homepage.getHeader().isDisplayed(), "Header is not displayed on the homepage");
    }

    @Test
    public void testHomepageTitle() {
        String expectedTitle = "Your Expected Homepage Title";
        Assert.assertEquals(homepage.getTitle(), expectedTitle, "Homepage title is incorrect");
    }

}


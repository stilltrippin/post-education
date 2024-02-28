package com.example.demo;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.openqa.selenium.By;

public final class ProductsTest  {

    private static final String FILE_PATH = "products.json";

    @AfterMethod(alwaysRun = true)
    public void captureScreenshotOnFailure(ITestResult result) {
        ITestNGMethod method = result.getMethod();
        LoginPage loginPage = new LoginPage(new WebDriver());
        if (ITestResult.FAILURE == result.getStatus()) {
            loginPage.captureScreenshot(
                    String.format(
                            "%s_%s_%s",
                            method.getRealClass().getSimpleName(),
                            method.getMethodName(),
                            method.getParameterInvocationCount()));
        }
    }

    @Test()
    public void testSuccessfulLogout() {
        loginPage.loginAs(data.getUsername(), data.getPassword()).clickOnLogout();
        assertThat(loginPage.getUrl()).isEqualTo(data.getUrl());
    }
}
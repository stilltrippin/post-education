package com.example.demo;

import org.junit.jupiter.api.Test;

public class AuthPageTest {
    private WebDriver driver;
    private AuthPage authPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("www.facebook.com");
        authPage = new AuthPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginWithValidCredentials() {
        String validEmail = "valid_email@example.com";
        String validPassword = "validPassword123";
        authPage.login(validEmail, validPassword);

        Assert.assertTrue(authPage.getHeader().isDisplayed(), "Header is not displayed after login");
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        String invalidEmail = "invalid_email@example.com";
        String invalidPassword = "invalidPassword123";
        authPage.login(invalidEmail, invalidPassword);
        Assert.assertTrue(authPage.isErrorShown(), "Error message is not displayed for invalid login");
    }

    @Test
    public void testSignupWithValidCredentials() {
        String name = "John Doe";
        String email = "john.doe@example.com";
        SignupPageBase signupPage = authPage.signup(name, email);
        Assert.assertTrue(signupPage.getHeader().isDisplayed(), "Header is not displayed on the signup page");
    }

    @Test
    public void testSignupWithInvalidEmail() {
        String invalidName = "John Doe";
        String invalidEmail = "invalid_email";
        SignupPageBase signupPage = authPage.signup(invalidName, invalidEmail);
        Assert.assertTrue(authPage.isErrorShown(), "Error message is not displayed for invalid email on signup");
    }
}
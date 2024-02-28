package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    @FindBy(css = "[data-qa='login-email']")
    private WebElement emailLoginInput;
    @FindBy(css = "[data-qa='login-password']")
    private WebElement passwordLoginInput;
    @FindBy(css = "[data-qa='login-button']")
    private WebElement loginButton;
    @FindBy(css = ".login-form p")
    private WebElement errorMessage;

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement signupNameInput;
    @FindBy(css = "[data-qa='signup-email']")
    private WebElement signupEmailInput;
    @FindBy(css = "[data-qa='signup-button']")
    private WebElement signupButton;

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignupPage signup(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
        return initPage(SignupPage.class, driver);
    }

    public void login(String email, String password) {
        emailLoginInput.sendKeys(email);
        passwordLoginInput.sendKeys(password);
        loginButton.click();
    }


    public boolean isErrorShown() {
        return errorMessage.isDisplayed();
    }


    public Header getHeader() {
        return header;
    }
}


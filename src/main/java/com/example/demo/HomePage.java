package com.example.demo;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.openqa.selenium.By;

public class HomePage extends AbstractPage {

    @FindBy(css = "h2.title")
    private WebElement messageTitle;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueBtn;

    @FindBy(id = "header")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getTitle() {
        return messageTitle.getText();
    }


    public HomePage clickContinue() {
        continueBtn.click();
        return initPage(HomePage.class, driver);
    }


    public Header getHeader() {
        return header;
    }

}

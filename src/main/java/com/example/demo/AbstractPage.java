package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 100);
        this.logger = LogManager.getLogger(this.getClass());
    }

    protected void click(WebElement element, String elementName) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Clicked on {}", elementName);
    }

    protected void sendKeys(WebElement element, String text, String elementName) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
        logger.info("Entered '{}' into {}", text, elementName);
    }

}


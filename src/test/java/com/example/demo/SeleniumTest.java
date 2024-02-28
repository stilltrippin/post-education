package com.example.demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SeleniumTest {
    private WebDriver driver;

    @FindBy(css = "input[name='q']")
    private WebElement searchInput;

    @FindBy(css = "input[name='btnK']")
    private WebElement searchButton;

    @FindBy(css = "h3")
    private List<WebElement> searchResults;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://vans.org.ua/");
        PageFactory.initElements(driver, this);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void searchTest() {
        searchInput.sendKeys("Product");
        searchButton.click();
        Assert.assertFalse(searchResults.isEmpty(), "Search results are empty");

        for (WebElement result : searchResults) {
            System.out.println(result.getText());
        }
    }

    @Test(enabled=true, dataProvider="categories", dataProviderClass=DataProvider.class)
    public void testcase1_create_category(String category) {
        ListCategoryPage.listCategories(driver, category);
    }

    @Test(enabled=true)
    public void testcase2_edit_category() {
        ListCategoryPage.editCategories(driver, "Chicken");
    }

    @Test(enabled=true)
    public void testcase3_delete_category() {
        ListCategoryPage.deleteCategories(driver);
    }
}


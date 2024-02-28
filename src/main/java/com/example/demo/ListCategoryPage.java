package com.example.demo;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.openqa.selenium.By;



public class ListCategoryPage {
    public static WebElement element = null;

    public static void clickListCategoryPage(WebDriver driver) {
        driver.findElement(By.id("go_list_categories")).click();
    }

    public static void clickAddtCategoryPage(WebDriver driver) {
        driver.findElement(By.id("go_add_category")).click();
    }

    public static void fillcategory(WebDriver driver, String str1) {
        element = driver.findElement(By.id("name"));
        element.clear();
        element.sendKeys(str1);
    }

    public static void clickSaveCategoryPage(WebDriver driver) {
        driver.findElement(By.id("submit")).click();
    }

    public static void editListedCategory(WebDriver driver) {
        try{
            List<WebElement> listedExpense = driver.findElements(
                    By.xpath("//*[@title='edit category']"));
            int size = listedExpense.size();
            for (int i=0; i<size;) {
                listedExpense.get(i).click();
                Reporter.log("clicked to edit the listed category");
            }
        }
        catch (Exception e) {
        }
    }

    public static void deleteListedCategory(WebDriver driver) {
        try{
            List<WebElement> listedExpense = driver.findElements(
                    By.xpath("//*[@title='delete category']"));
            int size = listedExpense.size();
            for (int i=0; i<size;) {
                listedExpense.get(i).click();
                Reporter.log("clicked to delete the listed category");
            }
        }
        catch (Exception e) {
        }
        Alert alert = driver.switchTo().alert();
        Reporter.log("pop up alert before deleting");
        alert.accept();
        Reporter.log("Accepted alert message and delete successful");
    }


    public static void listCategories(WebDriver driver, String str1) {
        clickListCategoryPage(driver);
        clickAddtCategoryPage(driver);
        fillcategory(driver, str1);
        clickSaveCategoryPage(driver);
    }


    public static void editCategories(WebDriver driver, String str1) {
        clickListCategoryPage(driver);
        editListedCategory(driver);
        fillcategory(driver, str1);
        clickSaveCategoryPage(driver);

    }


    public static void deleteCategories(WebDriver driver) {
        ListCategoryPage.clickListCategoryPage(driver);
        ListCategoryPage.deleteListedCategory(driver);
    }
}

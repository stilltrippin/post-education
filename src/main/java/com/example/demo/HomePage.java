package com.example.demo;

public class HomePage {

    @FindBy(css = "h2.title")
    private WebElement messageTitle;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueBtn;

    @FindBy(id = "header")
    private Header header;

    @Override
    public String getTitle() {
        return messageTitle.getText();
    }

    @Override
    public HomePage clickContinue() {
        continueBtn.click();
        return initPage(HomePage.class, driver);
    }

    @Override
    public Header getHeader() {
        return header;
    }

}

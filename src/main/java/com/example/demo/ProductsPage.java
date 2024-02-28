package com.example.demo;

public final class ProductsPage extends AbstractPage {

    private Header header;
    private SideNavMenu sideNavMenu;

    @FindBy(className = "title")
    private WebElement lblTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void initComponents() {
        header = new Header(driver);
        sideNavMenu = new SideNavMenu(driver);
    }

    public void clickOnLogout() {
        header.clickOnHamburgerIcon();
        sideNavMenu.clickOnLogout();
    }

    public String getTitle() {
        return lblTitle.getText();
    }
}

package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public void clickToRegisterLink() {
        clickToElement(driver, HomePageUI.REGISTER_LINK);
    }

    public boolean isMyAccountLinkDisplay() {
        waitForElementVisible(driver,HomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
    }
}

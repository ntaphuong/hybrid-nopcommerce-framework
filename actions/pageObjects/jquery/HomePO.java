package pageObjects.jquery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jquery.HomePageUI;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver){
        this.driver = driver;
    }

    public void openPageByNumber(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        clickToElement(driver,HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        sleepInSeconds(2);
    }
    public boolean isPageNumberActived(String pageNumber) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PAGE_LINK, pageNumber);
        return getElementAttribute(driver, HomePageUI.DYNAMIC_PAGE_LINK, "class",pageNumber).endsWith("active");
    }
    public void enterToTextboxByHeaderName(String headerName, String valueToSendkey){
        waitForElementVisible(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,headerName);
        sendKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME,valueToSendkey, headerName);
        pressKeyToElement(driver,HomePageUI.DYNAMIC_TEXTBOX_BY_HEADER_NAME, Keys.ENTER,headerName);
    }

    public boolean isRowDataValueisDisplayed(String female, String country, String male, String total) {
        waitForElementVisible(driver,HomePageUI.DYNAMIC_DATA_ROW,female,country,male,total);
        return isElementDisplay(driver,HomePageUI.DYNAMIC_DATA_ROW,female,country,male,total);
    }
}

package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.BasePageUI;
import pageUIs.SidebarPageUI;

public class SidebarPageObject extends BasePage {
    WebDriver driver;
    // constructor
    public SidebarPageObject(WebDriver driver){
        this.driver = driver;
    }
    public RewardPointPageObject openRewardPointPage(){
        waitForElementClickable(driver, SidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver,SidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getRewarPointPage(driver);
    }
    public AddressPageObject openAddressPage(){
        waitForElementClickable(driver, SidebarPageUI.ADDRESS_LINK);
        clickToElement(driver,SidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getAddressPage(driver);
    }
    public OrderPageObject openOrderPage(){
        waitForElementClickable(driver, SidebarPageUI.ORDER_LINK);
        clickToElement(driver,SidebarPageUI.ORDER_LINK);
        return PageGenerator.getOrderPage(driver);
    }
    public CustomerInfoPageObject openCustomerInfoPage(){
        waitForElementClickable(driver, SidebarPageUI.CUSTOMER_LINK);
        clickToElement(driver,SidebarPageUI.CUSTOMER_LINK);
        return PageGenerator.getCustomerInfoPage(driver);
    }
}

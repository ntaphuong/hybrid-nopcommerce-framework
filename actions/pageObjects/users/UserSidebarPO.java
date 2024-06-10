package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;
    // constructor
    public UserSidebarPO(WebDriver driver){
        this.driver = driver;
    }
    public UserRewardPointPO openRewardPointPage(){
        waitForElementClickable(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewarPointPage(driver);
    }
    public UserAddressPO openAddressPage(){
        waitForElementClickable(driver, UserSidebarPageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
    public UserOrderPO openOrderPage(){
        waitForElementClickable(driver, UserSidebarPageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
    public UserCustomerInfoPO openCustomerInfoPage(){
        waitForElementClickable(driver, UserSidebarPageUI.CUSTOMER_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }
}

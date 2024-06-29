package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserSidebarPageUI;

public class UserSidebarPO extends BasePage {
    WebDriver driver;
    // constructor
    public UserSidebarPO(WebDriver driver){
        this.driver = driver;
    }
    // Only use for Level_08_Page_Navigation
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
    // phù hợp cho số lượng page ít - vì switch case ít
    public UserSidebarPO openSidebarLinkByPageName(String pageName){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,pageName);

        switch (pageName){
            case "Addresses":
                return PageGenerator.getUserAddressPage(driver);
            case "Reward points":
                return PageGenerator.getUserRewarPointPage(driver);
            case "Customer info":
                return PageGenerator.getUserCustomerInfoPage(driver);
            case "Orders":
                return PageGenerator.getUserOrderPage(driver);
            default:
                 throw new RuntimeException("Page name is not valid!!!");
        }
    }
    // phù hợp cho số lượng page nhiều
    public void openSidebarLinkByPageNames(String pageName){
        waitForElementClickable(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME, pageName);
        clickToElement(driver, UserSidebarPageUI.DYNAMIC_LINK_BY_PAGE_NAME,pageName);
    }
}

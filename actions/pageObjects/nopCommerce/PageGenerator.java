package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.users.*;


public class PageGenerator {
    // Nếu làm 1 DA thì để tòn commons
    public static UserHomePO getUserHomePage(WebDriver driver) {
        return new UserHomePO(driver);
    }
    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }
    public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPO(driver);
    }
    public static UserCustomerInfoPO getUserCustomerPage(WebDriver driver) {
        return new UserCustomerInfoPO(driver);
    }
    public static UserRewardPointPO getUserRewarPointPage(WebDriver driver) {
        return new UserRewardPointPO(driver);
    }
    public static UserAddressPO getUserAddressPage(WebDriver driver) {
        return new UserAddressPO(driver);
    }
    public static UserOrderPO getUserOrderPage(WebDriver driver) {
        return new UserOrderPO(driver);
    }
    public static UserCustomerInfoPO getUserCustomerInfoPage(WebDriver driver){
        return new UserCustomerInfoPO(driver);
    }
    public static AdminDashboardPO getAdminDashboardPage (WebDriver driver){
        return new AdminDashboardPO(driver);
    }
    public static AdminLoginPO getAdminLoginPage (WebDriver driver){
        return new AdminLoginPO(driver);
    }
}

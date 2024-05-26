package pageObjects;

import org.bouncycastle.pqc.crypto.newhope.NHSecretKeyProcessor;
import org.openqa.selenium.WebDriver;

public class PageGenerator {
    // Nếu làm 1 DA thì để tòn commons
    public static HomePageObject getHomePage(WebDriver driver) {
        return new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver) {
        return new RegisterPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }
    public static RewardPointPageObject getRewarPointPage(WebDriver driver) {
        return new RewardPointPageObject(driver);
    }
    public static AddressPageObject getAddressPage(WebDriver driver) {
        return new AddressPageObject(driver);
    }
    public static OrderPageObject getOrderPage(WebDriver driver) {
        return new OrderPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver){
        return new CustomerInfoPageObject(driver);
    }
}

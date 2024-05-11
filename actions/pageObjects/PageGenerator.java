package pageObjects;

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


}

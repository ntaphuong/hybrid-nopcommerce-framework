package pageObjects.nopCommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.PageGenerator;
import pageUIs.nopCommerce.users.UserHomePageUI;
import pageUIs.nopCommerce.users.UserRegisterPageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;
    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }
    // Hàm khởi tạo (Constructor function)
    // 1 - Cùng tên vs tên Class
    // 2 - Không có kiểu trả về (Data type)
    // 3- Chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4 - Có tham số hoặc không
    // 5- Không tự define hàm khởi tạo thì JVM sẽ mặc định tạo ra 1 hàm khởi tạo rỗng

    public UserRegisterPO clickToRegisterLink() {
        waitForElementVisible(driver, UserHomePageUI.REGISTER_LINK);
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }

    public boolean isMyAccountLinkDisplay() {
        waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return isElementDisplay(driver, UserHomePageUI.MY_ACCOUNT_LINK);
    }

    public UserCustomerInfoPO clickToMyAccountLink() {
        waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerPage(driver);
    }
    public UserLoginPageObject OpenLoginPage(){
        waitForElementClickable(driver, UserRegisterPageUI.LOGIN_LINK);
        clickToElement(driver, UserRegisterPageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

}

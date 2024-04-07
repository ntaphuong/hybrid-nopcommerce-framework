package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
    // Hàm khởi tạo (Constructor function)
    // 1 - Cùng tên vs tên Class
    // 2 - Không có kiểu trả về (Data type)
    // 3- Chạy đầu tiên khi class này được gọi (new HomePageObject)
    // 4 - Có tham số hoặc không
    // 5- Không tự define hàm khởi tạo thì JVM sẽ mặc định tạo ra 1 hàm khởi tạo rỗng

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

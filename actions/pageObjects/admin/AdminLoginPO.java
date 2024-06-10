package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextbox(String emailAddress) {
    }

    public void enterToPasswordTextbox(String password) {
    }
    public AdminDashboardPO clickToLoginButton() {
        return PageGenerator.getAdminDashboardPage(driver);
    }


}

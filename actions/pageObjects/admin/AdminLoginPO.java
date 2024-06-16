package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.admin.adminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;
    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }
    public void enterToEmailTextbox(String emailAddress) {
        waitForElementVisible(driver, adminLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, adminLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementVisible(driver, adminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, adminLoginPageUI.PASSWORD_TEXTBOX,password);
    }
    public AdminDashboardPO clickToLoginButton() {
        waitForElementClickable(driver, adminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, adminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }


}

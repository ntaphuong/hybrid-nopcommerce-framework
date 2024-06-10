package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {
    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public UserHomePO clickToLoginButton() {
        waitForElementVisible(driver, UserLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
    public UserHomePO loginToSystem(String emailAddress, String password){
        enterToEmailTextBox(emailAddress);
        enterToPasswordTextBox(password);
        return clickToLoginButton();
    }
}

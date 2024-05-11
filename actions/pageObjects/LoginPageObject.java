package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void enterToEmailTextBox(String emailAddress) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToPasswordTextBox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX,password);
    }

    public HomePageObject clickToLoginButton() {
        waitForElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }
}

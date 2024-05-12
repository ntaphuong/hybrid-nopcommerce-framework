package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    public void clickToMaleRadio() {
        waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
        checkToCheckboxRadio(driver, RegisterPageUI.GENDER_MALE_RADIO);
    }

    public void EnterToFirstNameTexBox(String firstName) {
        waitForElementClickable(driver,RegisterPageUI.FIRST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void EnterToLastNameTextBox(String lastName) {
        waitForElementClickable(driver,RegisterPageUI.LAST_NAME_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void selectDayDropdown(String day) {
        waitForElementClickable(driver,RegisterPageUI.DAY_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.DAY_DROPDOWN,day);
    }

    public void selectMonthDropdown(String month) {
        waitForElementClickable(driver,RegisterPageUI.MONTH_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.MONTH_DROPDOWN,month);
    }

    public void selectYearDropdown(String year) {
        waitForElementClickable(driver,RegisterPageUI.YEAR_DROPDOWN);
        selectItemInDropdown(driver,RegisterPageUI.YEAR_DROPDOWN,year);
    }

    public void enterToEmailTextbox(String emailAddress) {
        waitForElementClickable(driver,RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.EMAIL_TEXTBOX,emailAddress);
    }

    public void enterToCompanyTextbox(String companyName) {
        waitForElementClickable(driver,RegisterPageUI.COMPANY_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.COMPANY_TEXTBOX,companyName);
    }

    public void enterToPasswordTextbox(String password) {
        waitForElementClickable(driver,RegisterPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.PASSWORD_TEXTBOX,password);
    }

    public void enterToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementClickable(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        waitForElementClickable(driver,RegisterPageUI.REGISTER_BUTTON);
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessage() {
        waitForElementVisible(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);

    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver,RegisterPageUI.LOGIN_LINK);
        clickToElement(driver,RegisterPageUI.LOGIN_LINK);
        return PageGenerator.getLoginPage(driver);
    }
    public void clickToLogoutLink() {
        waitForElementClickable(driver,RegisterPageUI.LOGOUT_LINK);
        clickToElement(driver,RegisterPageUI.LOGOUT_LINK);
    }
}

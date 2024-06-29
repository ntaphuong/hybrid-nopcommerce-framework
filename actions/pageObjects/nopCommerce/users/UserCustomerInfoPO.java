package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends UserSidebarPO {
    private WebDriver driver;
    public UserCustomerInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public boolean isGenderMaleSelected() {
        waitForElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
        return isElementSelected(driver, UserCustomerInfoPageUI.GENDER_MALE_RADIO);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
        return  getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.DAY_DROPDOWN);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
        return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.MONTH_DROPDOWN);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
        return getSelectedItemInDropdown(driver, UserCustomerInfoPageUI.YEAR_DROPDOWN);
    }

    public String getEmailTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.EMAIL_TEXTBOX,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX);
        return getElementAttribute(driver, UserCustomerInfoPageUI.COMPANY_TEXTBOX,"value");
    }
}

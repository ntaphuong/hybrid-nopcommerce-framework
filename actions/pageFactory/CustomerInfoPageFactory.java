package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePage{
    private WebDriver driver;
    public CustomerInfoPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="gender-male")
    private WebElement genderMaleRadio;
    @FindBy(id="FirstName")
    private WebElement firstNameTextbox;
    @FindBy(id="LastName")
    private WebElement lastNameTextBox;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    private WebElement dayDropDown;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    private WebElement monthDropDown;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    private WebElement yearDropDown;
    @FindBy(id="Email")
    private WebElement emailTextbox;
    @FindBy(id="Company")
    private WebElement companyTextbox;


    public boolean isGenderMaleSelected() {
        waitForElementVisible(driver, genderMaleRadio);
        return isElementSelected(genderMaleRadio);
    }

    public String getFirstNameTextboxValue() {
        waitForElementVisible(driver, firstNameTextbox);
        return getElementAttribute(firstNameTextbox,"value");
    }

    public String getLastNameTextboxValue() {
        waitForElementVisible(driver, lastNameTextBox);
        return getElementAttribute(lastNameTextBox,"value");
    }

    public String getDayDropdownSelectedValue() {
        waitForElementClickable(driver, dayDropDown);
        return getSelectedItemInDropdown(dayDropDown);
    }

    public String getMonthDropdownSelectedValue() {
        waitForElementClickable(driver, monthDropDown);
        return getSelectedItemInDropdown(monthDropDown);
    }

    public String getYearDropdownSelectedValue() {
        waitForElementClickable(driver, yearDropDown);
        return getSelectedItemInDropdown(yearDropDown);
    }

    public String getEmailTextBoxValue() {
        waitForElementVisible(driver, emailTextbox);
        return getElementAttribute(emailTextbox,"value");
    }

    public String getCompanyTextBoxValue() {
        waitForElementVisible(driver, companyTextbox);
        return getElementAttribute(companyTextbox,"value");
    }
}

package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;

public class Level_04_Multiple_Browser extends BaseTest {
    // Declare variables
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;
    private  String firstName, lastName, day, month, year, emailAddress, companyName, password;
    @Parameters("browser")
    // pre condition
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        // Mở URL lên, qua HomePage
        homePage = new HomePageObject(driver);
        firstName = "Phượng";
        lastName = "Nguyễn";
        day = "19";
        month = "January";
        year = "1989";
        emailAddress = "phuong"+generateRandomNumber()+"@gmail.com";
        companyName = "PhuongNTACompany";
        password = "123456";
    }
    @Test
    public void User_01_Register(){
        //Action 1
        homePage.clickToRegisterLink();
        // Từ Home Page qua Register Page
        registerPage = new RegisterPageObject(driver);

        registerPage.clickToMaleRadio();

        registerPage.EnterToFirstNameTexBox(firstName);
        registerPage.EnterToLastNameTextBox(lastName);
        registerPage.selectDayDropdown(day);
        registerPage.selectMonthDropdown(month);
        registerPage.selectYearDropdown(year);
        registerPage.enterToEmailTextbox(emailAddress);
        registerPage.enterToCompanyTextbox(companyName);
        registerPage.enterToPasswordTextbox(password);
        registerPage.enterToConfirmPasswordTextbox(password);
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }
    @Test
    public void User_02_Login(){
        registerPage.clickToLoginLink();
        // Từ Register Page qua Login Page
        loginPage = new LoginPageObject(driver);

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);
        loginPage.clickToLoginButton();

        // Từ Login Page qua Home page
        homePage = new HomePageObject(driver);

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyAccountLink();

        // Từ Home Page qua Customer Info Page
        customerInfoPage = new CustomerInfoPageObject(driver);
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day
        );
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextBoxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(),companyName);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

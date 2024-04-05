package com.nopcommerce.users;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CustomerInfoPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

import java.time.Duration;
import java.util.Random;

public class Level_03_Page_Object{
    // Declare variables
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerInfoPageObject customerInfoPage;

    // pre condition
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Mở URL lên, qua HomePage
        homePage = new HomePageObject();
    }
    @Test
    public void User_01_Register(){
        //Action 1
        homePage.clickToRegisterLink();
        // Từ Home Page qua Register Page
        registerPage = new RegisterPageObject();

        registerPage.clickToMaleRadio();

        registerPage.EnterToFirstNameTexBox("");
        registerPage.EnterToLastNameTextBox("");
        registerPage.selectDayDropdown("");
        registerPage.selectMonthDropdown("");
        registerPage.selectYearSropdown("");
        registerPage.enterToEmailTextbox("");
        registerPage.enterToCompanyTextbox("");
        registerPage.enterToPasswordTextbox("");
        registerPage.enterToConfirmPasswordTextbox("");
        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

    }
    @Test
    public void User_02_Login(){
        registerPage.clickToLoginButton();
        // Từ Register Page qua Login Page
        loginPage = new LoginPageObject();

        loginPage.enterToEmailTextBox("");
        loginPage.enterToPasswordTextBox("");
        loginPage.clickToLoginButton();

        // Từ Login Page qua Home page
        homePage = new HomePageObject();

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());


    }
    @Test
    public void User_03_MyAccount(){
        homePage.clickToMyAccountLink();

        // Từ Home Page qua Customer Info Page
        customerInfoPage = new CustomerInfoPageObject();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),"");
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),"");
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),"");
        Assert.assertEquals(customerInfoPage.getEmailTextBoxValue(),"");

    }
    public int generateRandomNumber(){
        return  new Random().nextInt(99999);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

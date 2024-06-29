package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;


public class Level_08_Page_Navigation extends BaseTest {
    // Declare variables
    private WebDriver driver;
    private UserHomePO homePage;
    private UserRegisterPO registerPage;
    private UserLoginPageObject loginPage;
    private UserCustomerInfoPO customerInfoPage;
    private UserAddressPO addressPage;
    private UserRewardPointPO rewardPointPage;
    private UserOrderPO orderPage;
    private  String firstName, lastName, day, month, year, emailAddress, companyName, password;
    @Parameters("browser")
    // pre condition
    @BeforeClass
    public void beforeClass(String browserName){
        driver = getBrowserDriver(browserName);
        // Mở URL lên, qua HomePage
        homePage = PageGenerator.getUserHomePage(driver);
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
//        //Action 1
//        homePage.clickToRegisterLink();
//        // Từ Home Page qua Register Page
//        registerPage = new RegisterPageObject(driver);
        registerPage = homePage.clickToRegisterLink();

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
        // Từ Register Page qua Login Page
        registerPage.clickToLogoutLink();
        loginPage = registerPage.clickToLoginLink();

        loginPage.enterToEmailTextBox(emailAddress);
        loginPage.enterToPasswordTextBox(password);


        // Từ Login Page qua Home page
        homePage = loginPage.clickToLoginButton();

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());


    }
    @Test
    public void User_03_MyAccount(){
        // Từ Home Page qua Customer Info Page
        customerInfoPage = homePage.clickToMyAccountLink();
        Assert.assertTrue(customerInfoPage.isGenderMaleSelected());

        Assert.assertEquals(customerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(customerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(customerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(customerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(customerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(customerInfoPage.getEmailTextBoxValue(),emailAddress);
        Assert.assertEquals(customerInfoPage.getCompanyTextBoxValue(),companyName);
    }
    @Test
    public void User_04_Switch_Page(){
        // Customer Info -> Address
        addressPage = customerInfoPage.openAddressPage();

        // Address -> Reward Point
        rewardPointPage= addressPage.openRewardPointPage();

        //Reward Point -> Order
        orderPage = rewardPointPage.openOrderPage();

        // Order -> Address
        addressPage = orderPage.openAddressPage();

        // Address -> Customer Info
        customerInfoPage = addressPage.openCustomerInfoPage();
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

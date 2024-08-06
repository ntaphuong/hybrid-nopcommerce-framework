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


public class Level_14_Log4j extends BaseTest {
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

//    public Level_14_Log4j() {
//        super(log);
//    }

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
    // LƯU Ý: Trên IntelliJIDEA nếu không hiển thị log thì cần config cho source folder resources là Resources Root

    @Test
    public void User_01_Register(){
        log.info("User_01_Register - STEP 01: Open Register Page");
        registerPage = homePage.openRegisterPage();

        log.info("User_01_Register - STEP 02: Click to Male Radio Button");
        registerPage.clickToMaleRadio();

        log.info("User_01_Register - STEP 03: Enter to Firstname textbox with value"+firstName);
        registerPage.EnterToFirstNameTexBox(firstName);

        log.info("User_01_Register - STEP 04: Enter to lastname textbox with value"+lastName);
        registerPage.EnterToLastNameTextBox(lastName);

        log.info("User_01_Register - STEP 05: select Day dropdown with value"+day);
        registerPage.selectDayDropdown(day);

        log.info("User_01_Register - STEP 06: Select Month dropdown with value"+month);
        registerPage.selectMonthDropdown(month);

        log.info("User_01_Register - STEP 07: Select Year dropdown with value"+year);
        registerPage.selectYearDropdown(year);

        log.info("User_01_Register - STEP 08: Enter to Email textbox with value"+ emailAddress);
        registerPage.enterToEmailTextbox(emailAddress);

        log.info("User_01_Register - STEP 09: Enter to Company textbox with value"+ companyName);
        registerPage.enterToCompanyTextbox(companyName);

        log.info("User_01_Register - STEP 10: Enter to Password textbox with value"+ password);
        registerPage.enterToPasswordTextbox(password);

        log.info("User_01_Register - STEP 11: Enter to Confirm Password textbox with value"+ password);
        registerPage.enterToConfirmPasswordTextbox(password);

        log.info("User_01_Register - STEP 12: Click to Register Button");
        registerPage.clickToRegisterButton();

        log.info("User_01_Register - STEP 13: Verify success message is displayed");
        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

        log.info("User_01_Register - STEP 14: Click to Logout Link");
        homePage = registerPage.clickToLogoutLink();

    }
    @Test
    public void User_02_Login(){
        loginPage = homePage.openLoginPage();
        homePage = loginPage.loginToSystem(emailAddress,password);
        Assert.assertTrue(homePage.isMyAccountLinkDisplay());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

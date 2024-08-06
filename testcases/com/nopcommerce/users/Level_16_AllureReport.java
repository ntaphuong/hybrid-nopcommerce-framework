package com.nopcommerce.users;

//import com.relevantcodes.extentreports.Status;

import commons.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.*;


@Feature("User")
public class Level_16_AllureReport extends BaseTest {
    String browserName;
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
        this.browserName = browserName;
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

    @Description("Register To Application")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void User_01_Register(){

        registerPage = homePage.openRegisterPage();

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

        Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

        homePage = registerPage.clickToLogoutLink();

    }
    @Description("Login To Application")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void User_02_Login(){

        homePage = registerPage.clickToLogoutLink();

        loginPage = homePage.openLoginPage();

        homePage = loginPage.loginToSystem(emailAddress,password);

        Assert.assertTrue(homePage.isMyAccountLinkDisplay());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageObjects.admin.AdminDashboardPO;
import pageObjects.admin.AdminLoginPO;
import pageObjects.users.UserHomePO;
import pageObjects.users.UserLoginPageObject;
import pageObjects.users.UserRegisterPO;

public class Level_09_Switch_Site_Url extends BaseTest {
    // Declare variables
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private String userUrlValue, adminUrlValue;

    private  String firstName, lastName, day, month, year, emailAddress, companyName, password;
    //@Parameters("browser")
    @Parameters({"browser","userUrl","adminUrl"})
    // pre condition
    @BeforeClass
    public void beforeClass(String browserName, String userUrl, String adminUrl){
        userUrlValue = userUrl;
        adminUrlValue = adminUrl;
        driver = getBrowserDriver(browserName,userUrlValue);
        // Mở URL lên, qua HomePage
        userHomePage = PageGenerator.getUserHomePage(driver);
        firstName = "Phượng";
        lastName = "Nguyễn";
        day = "19";
        month = "January";
        year = "1989";
        emailAddress = "phuong"+generateRandomNumber()+"@gmail.com";
        companyName = "PhuongNTACompany";
        password = "123456";

        // Pre-Condition
        userRegisterPage = userHomePage.clickToRegisterLink();
        userRegisterPage.clickToMaleRadio();
        userRegisterPage.EnterToFirstNameTexBox(firstName);
        userRegisterPage.EnterToLastNameTextBox(lastName);
        userRegisterPage.selectDayDropdown(day);
        userRegisterPage.selectMonthDropdown(month);
        userRegisterPage.selectYearDropdown(year);
        userRegisterPage.enterToEmailTextbox(emailAddress);
        userRegisterPage.enterToCompanyTextbox(companyName);
        userRegisterPage.enterToPasswordTextbox(password);
        userRegisterPage.enterToConfirmPasswordTextbox(password);
        userRegisterPage.clickToRegisterButton();

        Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");
    }
    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        // Từ Register Page qua Login Page
        userRegisterPage.clickToLogoutLink();
        userLoginPage = userRegisterPage.clickToLoginLink();
        // Từ Login Page qua Home page
        userHomePage = userLoginPage.loginToSystem(emailAddress,password);
        Assert.assertTrue(userHomePage.isMyAccountLinkDisplay());
        // Step đẻ order 1 product nào đó
        // .....
        // Qua trang Admin để verify / approve cái order ở trên vs quyền Admin
        userHomePage.openPageURL(driver,adminUrlValue);
        // Chưa login
        adminLoginPage = PageGenerator.getAdminLoginPage(driver);

        // Login vào trang Admin
        adminLoginPage.enterToEmailTextbox("");
        adminLoginPage.enterToPasswordTextbox("");
        adminDashboardPage = adminLoginPage.clickToLoginButton();

        // Đã login trước đó rồi
        adminDashboardPage = PageGenerator.getAdminDashboardPage(driver);

    }
    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        adminDashboardPage.openPageURL(driver,userUrlValue);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

package com.nopcommerce.users;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.admin.AdminDashboardPO;
import pageObjects.nopCommerce.admin.AdminLoginPO;
import pageObjects.nopCommerce.PageGenerator;
import pageObjects.nopCommerce.users.UserCustomerInfoPO;
import pageObjects.nopCommerce.users.UserHomePO;
import pageObjects.nopCommerce.users.UserLoginPageObject;
import pageObjects.nopCommerce.users.UserRegisterPO;

public class Level_09_Switch_Site_Url extends BaseTest {
    // Declare variables
    private WebDriver driver;
    private UserHomePO userHomePage;
    private UserRegisterPO userRegisterPage;
    private UserLoginPageObject userLoginPage;
    private AdminLoginPO adminLoginPage;
    private AdminDashboardPO adminDashboardPage;
    private UserCustomerInfoPO userCustomerInfoPage;
    private  String firstName, lastName, day, month, year, emailAddress, companyName, password;
    private String adminEmailAddress, adminPassword, userUrlValue, adminUrlValue;
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

        adminEmailAddress = "phuong@gmail.com";
        adminPassword = "12345678";

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
        userHomePage =  userRegisterPage.clickToLogoutLink();
    }
    @Test
    public void Role_01_User_Site_To_Admin_Site(){
        userLoginPage = userHomePage.OpenLoginPage();
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
        adminLoginPage.enterToEmailTextbox(adminEmailAddress);
        adminLoginPage.enterToPasswordTextbox(adminPassword);
        adminDashboardPage = adminLoginPage.clickToLoginButton();



    }
    @Test
    public void Role_02_Admin_Site_To_User_Site(){
        // Vào trang Order/ Customer/ ...
        // .....
        adminDashboardPage.openPageURL(driver,userUrlValue);
        userHomePage = PageGenerator.getUserHomePage(driver);
        // Action các step tiếp theo
        userCustomerInfoPage = userHomePage.clickToMyAccountLink();
        Assert.assertEquals(userCustomerInfoPage.getFirstNameTextboxValue(),firstName);
        Assert.assertEquals(userCustomerInfoPage.getLastNameTextboxValue(),lastName);
        Assert.assertEquals(userCustomerInfoPage.getDayDropdownSelectedValue(),day);
        Assert.assertEquals(userCustomerInfoPage.getMonthDropdownSelectedValue(),month);
        Assert.assertEquals(userCustomerInfoPage.getYearDropdownSelectedValue(),year);
        Assert.assertEquals(userCustomerInfoPage.getEmailTextBoxValue(),emailAddress);
        Assert.assertEquals(userCustomerInfoPage.getCompanyTextBoxValue(),companyName);

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

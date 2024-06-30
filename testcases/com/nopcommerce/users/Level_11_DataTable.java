package com.nopcommerce.users;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;


public class Level_11_DataTable extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }
   // @Test
    public void Table_01_Paging(){
        // Navigave to any page (paging)
        homePage.openPageByNumber("15");
        Assert.assertTrue(homePage.isPageNumberActived("15"));

        homePage.openPageByNumber("5");
        Assert.assertTrue(homePage.isPageNumberActived("5"));

        homePage.openPageByNumber("20");
        Assert.assertTrue(homePage.isPageNumberActived("20"));
    }
   @Test
    public void Table_02(){
        // Enter value to header textbox
        homePage.enterToTextboxByHeaderName("Country","Afghanistan");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueisDisplayed("384187","Afghanistan","407124","791312"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Females","283821");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueisDisplayed("283821","Algeria","295140","578961"));
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Males","295140");
        homePage.sleepInSeconds(3);
        Assert.assertTrue(homePage.isRowDataValueisDisplayed("283821","Algeria","295140","578961"));
        homePage.refreshCurrentPage(driver);

        // verify data

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

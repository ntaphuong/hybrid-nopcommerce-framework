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
    @Test
    public void Table_01(){
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


    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

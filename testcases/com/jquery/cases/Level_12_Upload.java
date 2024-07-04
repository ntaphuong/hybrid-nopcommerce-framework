package com.jquery.cases;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;


public class Level_12_Upload extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }
   // @Test
    public void Upload_01(){

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

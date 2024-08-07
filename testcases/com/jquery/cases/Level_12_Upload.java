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
    private  String dev, qa;

//    public Level_12_Upload() {
//        super(log);
//    }

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url){
        driver = getBrowserDriver(browserName,url);
        homePage = PageGenerator.getHomePage(driver);
        dev = "dev.png";
        qa= "qa.png";
    }
    @Test
    public void Upload_01(){
        // Lấy ra đường dẫn của file/ thư mục cho đúng
        // Tất cả các OS: Window/ MAC / Linux đều chạy được

        // Có thể upload 1 lần 1 file
//        homePage.uploadMultipleFiles(driver, dev);
//        homePage.sleepInSeconds(3);
//        homePage.refreshCurrentPage(driver);

        // Có thể upload 1 lần nhiều file
        homePage.uploadMultipleFiles(driver, qa);
        homePage.sleepInSeconds(3);
       // homePage.refreshCurrentPage(driver);

        // Verify load file lên
       // Assert.assertTrue(homePage.isFileLoadedByName(dev));
        Assert.assertTrue(homePage.isFileLoadedByName(qa));

        // Click upload button tại từng file
        homePage.clickToUploadButton(driver);

        // Có thể verify 1 file/ nhiều file được upload xong
       // Assert.assertTrue(homePage.isFileUpLoadByName(dev));
        Assert.assertTrue(homePage.isFileUpLoadByName(qa));

        // Có cần care tới open file Dialog không?  => không cần, vì cách đang làm không đụng tới open file dialog

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

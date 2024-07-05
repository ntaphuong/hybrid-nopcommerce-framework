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
    @Test
    public void Upload_01(){
        // Lấy ra đường dẫn của file/ thư mục cho đúng
        // Tất cả các OS: Window/ MAC / Linux đều chạy được

        // Có thể upload 1 lần 1 file => dùng 1 hàm

        // Có thể upload 1 lần nhiều file => dùng 1 hàm

        // Có thể verify  => dùng 1 hàm

        // Có cần care tới open file Dialog không?  => không cần, vì cách đang làm không đụng tới open file dialog

    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

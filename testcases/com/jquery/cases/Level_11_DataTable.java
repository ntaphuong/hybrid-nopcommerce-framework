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
  // @Test
    public void Table_02_Search_And_Verify(){
        // tìm ra 1 key duy nhất trong table- key của column, từ đó dùng giá trị này để đến được các action mong muốn
        // Enter value to header textbox and search
        homePage.enterToTextboxByHeaderName("Country","Afghanistan");
        homePage.sleepInSeconds(3);

       // verify data in first raw
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

    }
  //  @Test
    public void Table_03_Delete_Edit(){
        //  click Delete button
        homePage.enterToTextboxByHeaderName("Country","Afghanistan");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("Afghanistan");
        homePage.refreshCurrentPage(driver);

        homePage.enterToTextboxByHeaderName("Country","AFRICA");
        homePage.sleepInSeconds(3);
        homePage.deleteRowByCountryName("AFRICA");
        homePage.refreshCurrentPage(driver);

        // edit
        homePage.enterToTextboxByHeaderName("Country","Algeria");
        homePage.sleepInSeconds(3);
        homePage.editRowByCountryName("Algeria");
    }
   // @Test
    public void Table_04_Get_All_Value_Row_Or_Column(){
        // verify 2 cách:
        // 1. verify từng giá trị trả về
        // 2. Lưu trữ allValue trả về ra 1 file rồi so sánh
    homePage.getAllValueAtColumnName("Country");

    }
  //  @Test
    public void Table_05_Action_By_Index(){

        homePage.openPageURL(driver,"https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        homePage.clickLoadDataButton();
        // có thể thao tác với bất kỳ 1 column/ row nào
        homePage.enterToTextBoxByIndex("4", "Contact Person", "Phuongnta");
        homePage.enterToTextBoxByIndex("2", "Company", "MJ Company");

        homePage.selectToDropdownByIndex("6", "Country","Hong Kong");
        homePage.selectToDropdownByIndex("6", "Country","Japan");

        homePage.checkToCheckboxByIndex("6", "NPO?",true);
        homePage.checkToCheckboxByIndex("5", "NPO?",false);

        // Sau mỗi sự kiện đã thao tác thì index của từng row đã dc update lại
        homePage.clickToIconByIndex("8","Move Up");
        homePage.clickToIconByIndex("6","Remove");
        homePage.clickToIconByIndex("4","Insert");

    }
    @Test
    public void FaceBook(){
        homePage.openPageURL(driver,"https://www.facebook.com/61552580768222/videos/1935803176925065");


    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

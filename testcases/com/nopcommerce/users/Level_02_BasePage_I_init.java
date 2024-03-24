package com.nopcommerce.users;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_I_init {
    WebDriver driver;
    BasePage basePage; // Declare (khai báo)
    private  String firstName, lastName, day, month, year, emailAddress, companyName, password;
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        basePage = new BasePage(); // Khởi tạo

        driver.get("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        firstName = "Phượng";
        lastName = "Nguyễn";
        day = "19";
        month = "January";
        year = "1989";
        emailAddress = "phuong"+generateRandomNumber()+"@gmail.com";
        companyName = "PhuongNTACompany";
        password = "123456";
    }
    @Test
    public void TC_01_Register(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-register']");
        basePage.clickToElement(driver,"//a[@class='ico-register']");

        basePage.waitForElementClickable(driver,"//input[@id='gender-male']");
        basePage.clickToElement(driver,"//input[@id='gender-male']");

        basePage.sendKeyToElement(driver, "//input[@id='FirstName']", firstName);
        basePage.sendKeyToElement(driver, "//input[@id='LastName']", lastName);

        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthDay']",day);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthMonth']",month);
        basePage.selectItemInDropdown(driver,"//select[@name='DateOfBirthYear']",year);

        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Company']", companyName);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);
        basePage.sendKeyToElement(driver, "//input[@id='ConfirmPassword']", password);

        basePage.waitForElementClickable(driver,"//button[@id='register-button']");
        basePage.clickToElement(driver,"//button[@id='register-button']");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='result']"),"Your registration completed");
    }
    @Test
    public void TC_02_Login(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-login']");
        basePage.clickToElement(driver,"//a[@class='ico-login']");

        basePage.sendKeyToElement(driver, "//input[@id='Email']", emailAddress);
        basePage.sendKeyToElement(driver, "//input[@id='Password']", password);

        basePage.waitForElementClickable(driver,"//button[contains(@class,'login-button')]");
        basePage.clickToElement(driver,"//button[contains(@class,'login-button')]");

        Assert.assertTrue(basePage.isElementDisplay(driver,"//a[@class='ico-account' and text()='My account']"));

    }
    @Test
    public void TC_03_MyAccount(){
        basePage.waitForElementClickable(driver,"//a[@class='ico-account']");
        basePage.clickToElement(driver,"//a[@class='ico-account']");

        Assert.assertTrue(basePage.isElementSelected(driver,"//input[@id='gender-male']"));
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='FirstName']","value"),firstName);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='LastName']","value"),lastName);

        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthDay']"),day);
        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthMonth']"),month);
        Assert.assertEquals(basePage.getSelectedItemInDropdown(driver,"//select[@name='DateOfBirthYear']"),year);

        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Email']","value"),emailAddress);
        Assert.assertEquals(basePage.getElementAttribute(driver,"//input[@id='Company']","value"),companyName);

    }
    public int generateRandomNumber(){
        return  new Random().nextInt(99999);
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

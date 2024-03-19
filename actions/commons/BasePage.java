package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public void getURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }
    public String getPageTitle(WebDriver driver){
        return  driver.getTitle();
    }
    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }
    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }
    public void forwardToPage(WebDriver driver) {driver.navigate().forward();}
    public void refreshCurrentPage(WebDriver driver){driver.navigate().refresh();}
    public Alert waitAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }
    public void exceptToAlert(WebDriver driver){
        waitAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }
    public String getTextInAlert (WebDriver driver){
        return waitAlertPresence(driver).getText();
    }
    public void sendKeyToAlert (WebDriver driver, String KeysToSend){
        waitAlertPresence(driver).sendKeys(KeysToSend);
    }
    // Windows
    public void clickToElement(WebDriver driver, String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend){
        driver.findElement(By.xpath(locator)).sendKeys(keysToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select(driver.findElement(By.xpath(locator))).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator){
        return new Select(driver.findElement(By.xpath(locator))).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(driver.findElement(By.xpath(locator))).isMultiple();
    }
}

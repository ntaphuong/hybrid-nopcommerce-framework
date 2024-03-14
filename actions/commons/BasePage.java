package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    public Alert waitForAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }
    public void exceptToAlert(WebDriver driver){
        waitForAlertPresence(driver).accept();
    }
    public void cancelToAlert(WebDriver driver){
        waitForAlertPresence(driver).dismiss();
    }
    public String getTextInAlert (WebDriver driver){
        return waitForAlertPresence(driver).getText();
    }
    public void sendkeyToAlert (WebDriver driver, String KeysToSend){
        waitForAlertPresence(driver).sendKeys(KeysToSend);
    }
    // Windows

}

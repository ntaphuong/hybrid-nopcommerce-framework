package commons;

import org.openqa.selenium.WebDriver;

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
}

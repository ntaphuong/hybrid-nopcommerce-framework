package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import pageObjects.users.UserAddressPO;
import pageObjects.users.UserCustomerInfoPO;
import pageObjects.users.UserOrderPO;
import pageObjects.users.UserRewardPointPO;
import pageUIs.BasePageUI;
import pageUIs.users.UserSidebarPageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    // Tuân theo nguyên tắc của tính đóng gói (Encapsulation)
    // Hàm/ biến static có thể truy cập trực tiếp từ phạm vi class mà ko cần khởi tạo đối tượng đó
    public static BasePage getBasePage(){
        return new BasePage();
    }
    public void openPageURL(WebDriver driver, String pageURL){
        driver.get(pageURL);
    }
    public String getPageURL(WebDriver driver, String pageURL){
        return driver.getCurrentUrl();
    }
    public String getPageTitle(WebDriver driver){
        return  driver.getTitle();
    }
    public String getCurrentURL(WebDriver driver){
        return driver.getCurrentUrl();
    }
    public String getPageSourceCode(WebDriver driver){
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
    // Dùng trong TH chỉ có duy nhất 2 window hoặc 2 tab
    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWin = driver.getTitle();
            if (currentWin.equals(title)) {
                break;
            }
        }
    }

    public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            if (!runWindows.equals(parentID)) {
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
    }

    // WebElement
    public WebElement getElement(WebDriver driver, String locator){
        return driver.findElement(getByXpath(locator));
    }
    public List<WebElement> getListElement(WebDriver driver, String locator){
        return driver.findElements(getByXpath(locator));
    }
    public By getByXpath(String locator){
        return By.xpath(locator);
    }
    public void clickToElement(WebDriver driver, String locator){
        getElement(driver,locator).click();
    }
    public void sendKeyToElement(WebDriver driver, String locator, String keysToSend){
        getElement(driver,locator).clear();
        getElement(driver,locator).sendKeys(keysToSend);
    }
    public void selectItemInDropdown(WebDriver driver, String locator, String textItem){
        new Select( getElement(driver,locator)).selectByVisibleText(textItem);
    }
    public String getSelectedItemInDropdown(WebDriver driver, String locator){
        return new Select( getElement(driver,locator)).getFirstSelectedOption().getText();
    }
    public boolean isDropdownMultiple(WebDriver driver, String locator){
        return new Select(getElement(driver,locator)).isMultiple();
    }
    // CustomSDropdown
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();
        sleepInSeconds(2);

        List<WebElement> allItems =  new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childItemLocator)));
        sleepInSeconds(2);

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
//                jsExecutor = (JavascriptExecutor) driver;
//                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                //sleepInSecond(1);
                break;
            }
        }
    }
    public void sleepInSeconds(long timeInSeconds){
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public String getElementAttribute(WebDriver driver, String locator, String attributeName){
            return  getElement(driver, locator).getAttribute(attributeName);
    }
    public String getElementText(WebDriver driver, String locator){
            return getElement(driver,locator).getText();
    }
    public String getElementCssValue(WebDriver driver, String locator, String propertyName){
           return getElement(driver,locator).getCssValue(propertyName);
    }
    public String getHexaColorFromGRPA(String rgbaValue){
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }
    public int getListElementNumber(WebDriver driver, String locator){
           return getListElement(driver, locator).size();
    }
    public void checkToCheckboxRadio(WebDriver driver, String locator){
            if(!getElement(driver,locator).isSelected()){
                getElement(driver,locator).click();
            }
    }
    public void uncheckToCheckbox(WebDriver driver, String locator){
        if(getElement(driver,locator).isSelected()){
            getElement(driver,locator).click();
        }
}
    public boolean isElementDisplay(WebDriver driver, String locator){
        return getElement(driver,locator).isDisplayed();
}
    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }
    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }
    public void switchToIframe(WebDriver driver, String locator){
            driver.switchTo().frame(getElement(driver, locator));
    }
    public void switchToDefaultPage(WebDriver driver){
            driver.switchTo().defaultContent();
    }
    public void hoverToElement(WebDriver driver, String locator){
            new Actions(driver).moveToElement(getElement(driver,locator)).perform();
    }
    public void clickToElementByAction(WebDriver driver, String locator){
        new Actions(driver).click(getElement(driver,locator)).perform();
    }
    public void clickAndHoldToElement(WebDriver driver, String locator){
        new Actions(driver).clickAndHold(getElement(driver,locator)).perform();
    }
    public void releaseLeftMouse(WebDriver driver){
        new Actions(driver).release();
    }
    public void doubleClickToElement(WebDriver driver, String locator){
        new Actions(driver).doubleClick(getElement(driver,locator)).perform();
    }
    public void rightClickToElement(WebDriver driver, String locator){
        new Actions(driver).contextClick(getElement(driver,locator)).perform();
    }
    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator){
        new Actions(driver).dragAndDrop(getElement(driver,sourceLocator), getElement(driver,targetLocator)).perform();
    }
    public void pressKeyToElement(WebDriver driver, String locator, Keys keys){
        new Actions(driver).sendKeys(getElement(driver,locator),keys).perform();
    }
    public void ScrollToElement(WebDriver driver, String locator){
        new Actions(driver).scrollToElement(getElement(driver,locator)).perform();
    }

    // JavascriptExecutor
    public void hightlightElement(WebDriver driver, String locator) {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getElement(driver, locator));
        sleepInSeconds(3);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getElement(driver, locator));
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(driver, locator));
    }

    public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    // Wait
    public void waitForElementVisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForElementPresent(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(getByXpath(locator)));
    }
    public void waitForElementInvisible(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }
    public void waitForElementSelected(WebDriver driver, String locator){
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeSelected(getByXpath(locator)));
    }

    // 4 hàm sau dùng cho Level_07_Switch_Page_Object
    public UserRewardPointPO openRewardPointPage(WebDriver driver){
        waitForElementClickable(driver, BasePageUI.REWARD_POINT_LINK);
        clickToElement(driver, UserSidebarPageUI.REWARD_POINT_LINK);
        return PageGenerator.getUserRewarPointPage(driver);
    }
    public UserAddressPO openAddressPage(WebDriver driver){
        waitForElementClickable(driver, BasePageUI.ADDRESS_LINK);
        clickToElement(driver, UserSidebarPageUI.ADDRESS_LINK);
        return PageGenerator.getUserAddressPage(driver);
    }
    public UserOrderPO openOrderPage(WebDriver driver){
        waitForElementClickable(driver, BasePageUI.ORDER_LINK);
        clickToElement(driver, UserSidebarPageUI.ORDER_LINK);
        return PageGenerator.getUserOrderPage(driver);
    }
    public UserCustomerInfoPO openCustomerInfoPage(WebDriver driver){
        waitForElementClickable(driver, BasePageUI.CUSTOMER_LINK);
        clickToElement(driver, UserSidebarPageUI.CUSTOMER_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

}

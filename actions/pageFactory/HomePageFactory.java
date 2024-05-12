package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePageObject;

public class HomePageFactory extends BasePage{
    private WebDriver driver;
    public HomePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy( how = How.CLASS_NAME, using = "ico-register")
    private WebElement registerLink; // bắt buộc phải là WebElement để PagaFactory nó khởi ta

   @FindBy(className = "ico-account")
    private WebElement myAccountLink;

    public void clickToRegisterLink() {
        waitForElementClickable(driver, registerLink);
        clickToElement(registerLink);

    }

    public boolean isMyAccountLinkDisplay() {
        waitForElementVisible(driver,myAccountLink);
        return isElementDisplay(myAccountLink);
    }

    public void clickToMyAccountLink() {
        waitForElementClickable(driver,myAccountLink);
        clickToElement(myAccountLink);
    }
}

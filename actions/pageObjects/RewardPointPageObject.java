package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class RewardPointPageObject extends SidebarPageObject {
        private WebDriver driver;
    public RewardPointPageObject(WebDriver driver) {
        // hàm super gọi đến constructor của lớp cha
        super(driver);
        this.driver = driver;
        }

    }

package pageObjects.nopCommerce.users;

import org.openqa.selenium.WebDriver;

public class UserRewardPointPO extends UserSidebarPO {
        private WebDriver driver;
    public UserRewardPointPO(WebDriver driver) {
        // hàm super gọi đến constructor của lớp cha
        super(driver);
        this.driver = driver;
        }

    }

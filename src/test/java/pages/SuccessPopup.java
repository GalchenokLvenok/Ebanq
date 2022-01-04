package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPopup extends BasePage {
    public static final By SUCCESS_TEXT = By.xpath("//*[@class='success-popup']//div[contains(text(),'Your request has been sent for approval. Request ID')]");

    public SuccessPopup(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(SUCCESS_TEXT);
    }
}

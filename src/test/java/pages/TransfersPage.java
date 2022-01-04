package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransfersPage extends BasePage {
    public static final By CONTAINER = By.cssSelector(".sections-container");

    public TransfersPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(CONTAINER);
    }

    public TransfersPage open() {
        driver.get(URL + "transfer");
        return this;
    }
}

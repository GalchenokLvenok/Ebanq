package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    By SITE_LOGO_INNER = By.cssSelector(".header .aside-bar__image");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return driver.findElement(SITE_LOGO_INNER).isDisplayed();

    }
}

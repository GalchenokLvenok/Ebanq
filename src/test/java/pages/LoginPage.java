package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final By USERNAME_INPUT = By.cssSelector("[type = email]");
    public static final By PASSWORD_INPUT = By.cssSelector("[type = password]");
    public static final By LOGIN_BUTTON = By.cssSelector("[type = submit]");
    String ERROR_TEXT = "//*[@type='%s']//following-sibling::label[@class='error-word']";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(LOGIN_BUTTON);
    }

    public LoginPage open() {
        driver.get(URL + "log-in");
        return this;
    }

    public void login(String user, String psw) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(psw);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorMessage(String type) {
        return driver.findElement(By.xpath(String.format(ERROR_TEXT, type))).getText();
    }
}

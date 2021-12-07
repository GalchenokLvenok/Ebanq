package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
    public static final By USERNAME_INPUT = By.cssSelector("[type = email]");
    public static final By PASSWORD_INPUT = By.cssSelector("[type = password]");
    public static final By LOGIN_BUTTON = By.cssSelector("[type = submit]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demo.ebanq.com/log-in");
    }

    public void login(String user, String psw) {
        driver.findElement(USERNAME_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(psw);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public WebElement getElement(By element) {
        return driver.findElement(element);
    }

    public WebElement waitVisibilityOfElement(By element) {
        return new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(element));
    }
}

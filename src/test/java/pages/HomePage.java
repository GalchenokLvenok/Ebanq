package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://ebanq.com/");
    }

    public WebElement getElement(By element) {
        return driver.findElement(element);
    }

    public String getText(String text) {
        return driver.findElement(By.id(text)).getText();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://ebanq.com/");
    }

    public WebElement getElement(String element) {
        return driver.findElement(By.id(element));
    }

    public String getText(String text) {
        return driver.findElement(By.id(text)).getText();
    }
}

package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    By textLocator = By.id("description");

    public TextArea(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(textLocator).sendKeys(text);
    }
}

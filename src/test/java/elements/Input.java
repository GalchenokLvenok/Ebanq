package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    By inputLocator = By.xpath("//input[contains(@formcontrolname, 'outgoingAmount')]");
    By textLocator = By.cssSelector("#description");

    public Input(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        System.out.println(String.format("Writing text '%s' into input", text));
        driver.findElement(inputLocator).sendKeys(text);
    }
}

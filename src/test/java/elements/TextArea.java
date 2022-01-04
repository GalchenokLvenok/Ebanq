package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;
    String textLocator = "//label[contains(text(),'%s')]//following::textarea";

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void enterText(String text) {
        driver.findElement(By.xpath(String.format(textLocator, label))).sendKeys(text);
    }
}

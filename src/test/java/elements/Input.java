package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;
    String inputLocator = "//input[contains(@title, '%s')]";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void enterText(int text) {
        System.out.println(String.format("Writing text '%s' into input", text));
        driver.findElement(By.xpath(String.format(inputLocator, label))).clear();
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(String.valueOf(text));
    }
}

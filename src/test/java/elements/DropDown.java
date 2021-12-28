package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDown {
    WebDriver driver;
    String label;
    String selectorLocator = "//app-account-select[contains(@ng-reflect-select-label, '%s')]//descendant::ng-select";
    String optionLocator = "//ng-dropdown-panel[contains(@class,'ng-select-bottom')]//span[text()='%s']";

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        driver.findElement(By.xpath(String.format(selectorLocator, label))).click();
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
    }
}

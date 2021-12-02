package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateHomePageTest extends BaseTest{

    @Test
    public void validateVisibleEllements() {
        homePage.open();
        WebElement ebanq = driver.findElement(By.id("site-logo-inner"));
        assertNotNull(ebanq,"Home page is not displayed");
    }
}

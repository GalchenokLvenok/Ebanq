package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateHomePageTest extends BaseTest{
    By SITE_LOGO_INNER = By.cssSelector("#site-logo-inner");

    @Test
    public void validateVisibleEllements() {
        homePage.open();
        assertNotNull(homePage.getElement(SITE_LOGO_INNER),"Home page is not opened");

        //Validate that all elements are on the Home page
        assertEquals(homePage.getText("menu-item-4174"),"HOME","HOME element is absent");
    }
}

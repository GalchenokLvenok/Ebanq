package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateHomePageTest extends BaseTest{

    @Test
    public void validateVisibleEllements() {
        homePage.open();
        assertNotNull(homePage.getElement("site-logo-inner"),"Home page is not opened");

        //Validate that all elements are on the Home page
        assertEquals(homePage.getText("menu-item-4174"),"HOME","HOME element is absent");
    }
}

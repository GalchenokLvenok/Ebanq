package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    String USER_LOGIN = "Demo-User";
    String USER_PSW = "Demo-Access1";
    String ERROR_TEXT = "Field is required.";
    String WRONG_TEXT = "Wrong username or password.";
    By SITE_LOGO_INNER = By.cssSelector(".header .aside-bar__image");
    By ERROR_LOGIN_TEXT = By.xpath("//*[@type='email']//following-sibling::label[@class='error-word']");
    By ERROR_PSW_TEXT = By.xpath("//*[@type='password']//following-sibling::label[@class='error-word']");

    @Test
    public void loginShouldBeValid() {
        loginPage.open();
        loginPage.login(USER_LOGIN,USER_PSW);
        assertNotNull(loginPage.getElement(SITE_LOGO_INNER),"Login is failed");
    }

    @Test
    public void loginShouldNotBeEmpty() {
        loginPage.open();
        loginPage.login("",USER_PSW);
        assertEquals(loginPage.getElement(ERROR_LOGIN_TEXT).getText(),ERROR_TEXT,"Empty login validation doesn't work");
    }

    @Test
    public void passwordShouldNotBeEmpty() {
        loginPage.open();
        loginPage.login(USER_LOGIN,"");
        assertEquals(loginPage.getElement(ERROR_PSW_TEXT).getText(),ERROR_TEXT,"Empty password validation doesn't work");
    }

    @Test
    public void UsernameAndPasswordShouldBeCorrect() {
        loginPage.open();
        loginPage.login("Demo","12345678");
        loginPage.waitVisibilityOfElement(By.cssSelector(".sn-content"));
        assertEquals(loginPage.getElement(ERROR_PSW_TEXT).getText(),WRONG_TEXT,"Incorrect username and password validation doesn't work");
    }
}

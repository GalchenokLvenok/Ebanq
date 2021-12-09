package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    String ERROR_TEXT = "Field is required.";
    String WRONG_TEXT = "Wrong username or password.";
    String WAIT_ERROR_MESSAGE = ".sn-content";

    @Test
    public void loginShouldBeValid() {
        loginPage.open();
        loginPage.login(USER_LOGIN,USER_PSW);
        assertTrue(homePage.isPageOpened(),"Login is failed");
    }

    @Test
    public void loginShouldNotBeEmpty() {
        loginPage.open();
        loginPage.login("",USER_PSW);
        assertEquals(loginPage.getErrorMessage("email"),ERROR_TEXT,"Empty login validation doesn't work");
    }

    @Test
    public void passwordShouldNotBeEmpty() {
        loginPage.open();
        loginPage.login(USER_LOGIN,"");
        assertEquals(loginPage.getErrorMessage("password"),ERROR_TEXT,"Empty password validation doesn't work");
    }

    @Test
    public void UsernameAndPasswordShouldBeCorrect() {
        loginPage.open();
        loginPage.login("Demo","12345678");
        loginPage.waitVisibilityOfElement(WAIT_ERROR_MESSAGE);
        assertEquals(loginPage.getErrorMessage("password"),WRONG_TEXT,"Incorrect username and password validation doesn't work");
    }
}

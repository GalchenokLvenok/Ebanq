package tests;

import models.Transfer;
import models.TransferFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TransferBetweenAccountsTest extends BaseTest {

    @Test
    public void transferShouldBeSucceed() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PSW);
        assertTrue(homePage.isPageOpened(), "Login is failed");
        transfersBetweenAccountsPage.open();
        assertTrue(transfersBetweenAccountsPage.isPageOpened(), "Transfer between accounts page is not opened");

        Transfer transfer = TransferFactory.get();

        transfersBetweenAccountsPage
                .fillTransfer(transfer)
                .submit("Continue")
                .submit("Confirm");
        assertTrue(successPopup.isPageOpened(), "Transfer is not succeed");
    }

    @Test
    public void transferShouldBeChanged() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PSW);
        assertTrue(homePage.isPageOpened(), "Login is failed");
        transfersBetweenAccountsPage.open();
        assertTrue(transfersBetweenAccountsPage.isPageOpened(), "Transfer between accounts page is not opened");

        Transfer transfer = TransferFactory.get();

        transfersBetweenAccountsPage
                .fillTransfer(transfer)
                .submit("Continue")
                .submit("Back");

        Transfer transfer2 = TransferFactory.get("EBQ11113487654","EBQ11223487456");

        transfersBetweenAccountsPage
                .fillTransfer(transfer2)
                .submit("Continue")
                .submit("Confirm");
        assertTrue(successPopup.isPageOpened(), "Transfer is not succeed");
    }

    @Test
    public void transferShouldBeCanceled() {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PSW);
        assertTrue(homePage.isPageOpened(), "Login is failed");
        transfersBetweenAccountsPage.open();
        assertTrue(transfersBetweenAccountsPage.isPageOpened(), "Transfer between accounts page is not opened");

        Transfer transfer = TransferFactory.get();

        transfersBetweenAccountsPage
                .fillTransfer(transfer)
                .submit("Cancel");
        assertTrue(transfersPage.isPageOpened(), "Transfer is not succeed");
    }
}

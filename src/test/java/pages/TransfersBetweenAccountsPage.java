package pages;

import elements.DropDown;
import elements.Input;
import elements.TextArea;
import models.Transfer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TransfersBetweenAccountsPage extends BasePage {
    public static final By TITLE = By.xpath("//div[text() = 'Transfer Between Accounts']");
    String submit_button = "//div[@class='bottom']//*[contains(text(),'%s')]";

    public TransfersBetweenAccountsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isExist(TITLE);
    }

    public TransfersBetweenAccountsPage open() {
        driver.get(URL + "transfer/transfer-between-accounts");
        return this;
    }

    public TransfersBetweenAccountsPage fillTransfer(Transfer transfer) {
        new DropDown(driver, "Debit from").select(transfer.getDebitAccount());
        new DropDown(driver, "Credit to").select(transfer.getCreditAccount());
        new Input(driver, "Outgoing Amount").enterText(transfer.getAmountTransfer());
        new TextArea(driver, "Description").enterText(transfer.getDescriptionTransfer());
        return new TransfersBetweenAccountsPage(driver);
    }

    public TransfersBetweenAccountsPage submit(String name) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(String.format(submit_button, name)))).click(driver.findElement(By.xpath(String.format(submit_button, name))));
        builder.perform();
        return new TransfersBetweenAccountsPage(driver);
    }
}

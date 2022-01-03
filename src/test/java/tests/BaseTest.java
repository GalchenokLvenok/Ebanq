package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    public static final String USER_LOGIN = "Demo-User";
    public static final String USER_PSW = "Demo-Access1";
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    TransfersBetweenAccountsPage transfersBetweenAccountsPage;
    TransfersPage transfersPage;
    SuccessPopup successPopup;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        options.addArguments("--start-maximized");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        transfersBetweenAccountsPage = new TransfersBetweenAccountsPage(driver);
        transfersPage = new TransfersPage(driver);
        successPopup = new SuccessPopup(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}

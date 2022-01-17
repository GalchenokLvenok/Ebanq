package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {
    public static final String USER_LOGIN = "Demo-User";
    public static final String USER_PSW = "Demo-Access1";
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    TransfersBetweenAccountsPage transfersBetweenAccountsPage;
    TransfersPage transfersPage;
    SuccessPopup successPopup;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if(browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();
            options.addArguments("--start-maximized");
        } else if(browser.equals("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        testContext.setAttribute("driver", driver);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

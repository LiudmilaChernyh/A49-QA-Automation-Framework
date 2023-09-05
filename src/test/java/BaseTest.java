import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;
import java.util.UUID;

public class BaseTest {

    public static WebDriver driver = null;
    public static Actions actions = null;

    public static String url = "https://qa.koel.app/";

    static WebDriverWait wait;
    static BasePage basePage;
    static LoginPage loginPage;
    static HomePage homePage;






    @BeforeSuite

    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})

    public static void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions (driver);
        basePage = new BasePage(driver,wait,actions);
        basePage. navigateToPage(url);
        loginPage = new LoginPage(driver, wait,actions);
        homePage = new HomePage(driver,wait,actions);


    }









    @AfterMethod

    public static void closeBrowser () {
        basePage.quitBrowser();

    }



}
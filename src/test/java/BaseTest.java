import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;

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
        options.setExperimentalOption("exludeSwitches",new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        url=BaseURL;
        driver.get(url);

          }


    @AfterMethod

    public static void closeBrowser () {
        driver.quit();

    }

}
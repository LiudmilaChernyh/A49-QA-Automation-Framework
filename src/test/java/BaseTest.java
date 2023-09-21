
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
public class BaseTest {
    public WebDriver driver ;
    public String url = "https://qa.koel.app/";
    @BeforeClass
    public void setupClass() throws MalformedURLException {
        String browser = System.getProperty("browser");
        driver=setupBrowser(browser);
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
    WebDriver setupBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.105:4444";
        return switch (browser) {
            case "chrome" -> setupChrome();
            case "safari" -> setupSafari();
            case "grid-chrome" -> {
                caps.setCapability("browserName", "chrome");
                yield driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            }
            default -> setupChrome();
        };
    }public WebDriver setupSafari(){
        WebDriverManager.safaridriver().setup();
        driver =new SafariDriver();
        return driver;
    }
    public WebDriver setupChrome(){
        WebDriverManager.chromedriver().setup();
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        return driver;
    }
}








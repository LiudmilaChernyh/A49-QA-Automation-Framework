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

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;

    public static String url = null;
    public static  WebDriverWait wait= null;
    public static Actions actions = null;





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
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);
    }
    // Helper Methods


    public static void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public static void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickMyPlaylist() throws InterruptedException{

        WebElement myPlayListElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        myPlayListElement.click();


    }
    public void clickDeleteMyPlaylist(){

        WebElement clickDeleteMyPlaylistElement = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        clickDeleteMyPlaylistElement.click();
    }



    public String getDeletedPlaylistNotification() {

        WebElement getDeletedPlaylistElement = driver.findElement(By.cssSelector("div.success.show"));
        return getDeletedPlaylistElement.getText();

    }

    @AfterMethod

    public static void closeBrowser () {

        driver.quit();
    }
}
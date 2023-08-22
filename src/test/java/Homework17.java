
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;




public class Homework17 extends BaseTest {
    WebDriver driver;
    @Test
    public void addSongToPlayList() throws InterruptedException{
        String expectedSongAddedMessage = "Added 1 song into\" Test Pro Playlist.\"";
        navigateToPage (//qa.koel.app/);
        provideEmail ("liudmila.chernyh@testpro.io");
        providePassword ("te$tStudent");
        clickSubmit();
        Thread.sleep(2000);
        searchSong ("Dark Days");
        clickViewAllBtn();
        selectFirstSongresult();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMessage);





    

    }

    public String getAddToPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    public void choosePlaylist()throws InterruptedException {
        WebElement addToButton = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']"));
    }

    public void clickAddToBtn() throws  InterruptedException{
        WebElement addToButton =driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn'"));
    }

    public  void selectFirstSongresult() throws InterruptedException {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn'"));
    }

    public void clickViewAllBtn() throws InterruptedException {
        WebElement viewAll = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn'"));
    }

    public void searchSong(String darkDays) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector("div# searchForm input [type='search'"));
        searchField.sendKeys(Dark Days);
        Thread.sleep(2000);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button [type=submit']"));
    }

    public void providePassword(String te$tStudent) {
        WebElement passwordField=driver.findElement(By.cssSelector("input [type='password']"));
        passwordField.clear();
        passwordField.sendKeys();
    }

    public void provideEmail(String mail) {
        WebElement emailField =driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys();
    }

    public void navigateToPage() {
        driver.getCurrentUrl();
    }
}

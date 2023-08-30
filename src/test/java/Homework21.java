import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;



public class Homework21 extends BaseTest{


    @Test
    public void renamePlaylist() throws InterruptedException {
        String updatedPlaylistMsg = "Updated playlist\"Deleted Playlist\"";
        String playlistName = "Deleted Playlist";


        navigateToPage();
        provideEmail("liudmila.chernyh@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        doubleClickPlaylist();
        enterNewPlaylistName();


        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }

    private String getRenamePlaylistSuccessMsg() {
        WebElement notification =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    private void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys (Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(Keys.ENTER);

    }

    private void doubleClickPlaylist() {
        WebElement playlistElement =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='playlists']/ul/li[3]")));
        actions.doubleClick(playlistElement).perform();
    }

    private void navigateToPage() {
        driver.get(url);
    }
    public static void clickSubmit() throws InterruptedException {
        WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        submitButton.click();


    }




    }








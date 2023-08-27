import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist()throws InterruptedException{
    String expectedPlaylistDeletedMessege ="Deleted playlist\"TestPro Playlist.\"";
    provideEmail("demo@class.com");
    providePassword("te$t$tudent");
    clickSubmit();
    openPlaylist();
    deletePlaylistBtn();
    clickonOk();
    
    getDeletedPlayListMsg();
    Assert.assertEquals(getDeletedPlayListMsg(),expectedPlaylistDeletedMessege);


    }

    private void clickonOk() {
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }

    private String getDeletedPlayListMsg() {
        WebElement notificationMsg= driver.findElement(By.cssSelector("div.success.show"));
        return notificationMsg.getText();

    }

    private void deletePlaylistBtn() throws InterruptedException{
        WebElement deletePlaylist= driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylist.click();

    }

    private void openPlaylist() {
        WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        emptyPlaylist.click();
    }
}

//
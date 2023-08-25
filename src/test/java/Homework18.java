import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static java.lang.Thread.*;

public class Homework18 extends BaseTest {
    @Test()
    public void playSong()throws InterruptedException{
        navigateToPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(3000);
        clickPlayNextBtn();
        checkSongIsPlaying();


    }

    private void checkSongIsPlaying() {
        WebElement soundBar = driver.findElement(By.cssSelector("[data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBar.isDisplayed());
    }
    private void clickPlayNextBtn() throws InterruptedException {
        WebElement playNexBtn = driver.findElement(By.cssSelector("[data-testid='play-next-btn']"));
        playNexBtn.click();
        WebElement playBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        playBtn.click();
    }



    }




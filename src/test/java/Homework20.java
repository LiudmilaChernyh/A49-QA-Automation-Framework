
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException{

        String playlistDeletedMessage ="Deleted playlist";
        navigateToPage();
        provideEmail("liudmila.chernyh@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        clickMyPlaylist();
        clickDeleteMyPlaylist();
        Assert.assertTrue(getDeletedPlaylistNotification().contains(playlistDeletedMessage));
    }

    private void navigateToPage() {
        driver.get(url);
    }
}


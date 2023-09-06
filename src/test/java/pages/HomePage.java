package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    private final By userAvatarIcon = By.cssSelector("img.avatar");
    private final By playlistInput = By.cssSelector("[name='name']");
    private final By alert =By.cssSelector("div.success.show");
    private final By playlist= By.xpath("//*[@id='playlists']/ul/li[3]");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }
    public String getRenamePlaylistSuccessMsg (){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
        return notification.getText();
    }

    private void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A"));
        playlistInputField.sendKeys(Keys.BACK_SPACE);
        playlistInputField.sendKeys(playlistName);
        playlistInputField.sendKeys(Keys.ENTER);

    }
    private void doubleClickPlaylist() {
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(playlist));
        actions.doubleClick(playlistElement).perform();
    }


}







package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    //private final By userAvatarIcon = By.cssSelector("img.avatar");
    //private final By playlistInput = By.cssSelector("[name='name']");
    //private final By alert =By.cssSelector("div.success.show");
    //private final By playlist= By.xpath("//*[@id='playlists']/ul/li[3]");
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //public WebElement getUserAvatar(){
        //return findElement(userAvatarIcon);
    //}
   //public String getRenamePlaylistSuccessMsg (){
     //   WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(alert));
      //  return notification.getText();
    //}
    @FindBy(css = "[class='playlist playlist']")
    private WebElement doubleClick;
    @FindBy(css = "[name='name']")
    private WebElement playListInputField;
    public HomePage doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClick));
        actions.doubleClick(doubleClick).perform();
        return this;
    }
    public HomePage enterNewPlayListName(String playListName) {
        wait.until(ExpectedConditions.elementToBeClickable(playListInputField));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playListInputField.sendKeys(playListName);
        playListInputField.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePage getRenamePlaylistSuccessMsg (){
        wait.until(ExpectedConditions.elementToBeClickable(alert));
        return this;
    }

}







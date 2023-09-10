package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy(css = "[class='playlist playlist']")
    private WebElement doubleClick;
    @FindBy(css = "[name='name']")
    private WebElement playListInputField;
    @FindBy(css = "div.success.show")
    private WebElement alert;
    public HomePage doubleClickPlaylist() {
        wait.until(ExpectedConditions.elementToBeClickable(doubleClick));
        actions.doubleClick(doubleClick).perform();
        return this;
    }
    public String getRenamePlaylistSuccessMsg (){
        WebElement notification = wait.until(ExpectedConditions.elementToBeClickable(alert));
        return notification.getText();
    }

    public HomePage enterNewPlaylistName(String playlistName) {
        wait.until(ExpectedConditions.elementToBeClickable(playListInputField));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playListInputField.sendKeys(playlistName);
        playListInputField.sendKeys(Keys.ENTER);
        return this;
    }

}


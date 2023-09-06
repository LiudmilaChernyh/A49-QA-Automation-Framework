package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

public class BasePage {
    protected Actions actions;
    protected WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver,WebDriverWait wait, Actions actions){
        this.driver = driver;
        this.wait = wait;
        this.actions = actions;

    }
    public void navigateToPage(String url)  {driver.get(url);}
    public String generateRandomName(){
        return UUID.randomUUID().toString().replace( "-","");}
    public void clickOnOk(){
        WebElement okBtn = driver.findElement(By.cssSelector(".ok"));
        okBtn.click();
    }
    void cllickOnElement (By locator){
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
    }
    void enterText (By locator,String text){
        WebElement el=wait.until(ExpectedConditions.elementToBeClickable(locator));
        el.click();
        el.clear();
        el.sendKeys(text);
    }
    public void quitBrowser(){
        driver.quit();

    }
}

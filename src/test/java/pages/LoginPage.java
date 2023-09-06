package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage{
    //private final By emailField = By.cssSelector("input[type='email']");
    //public final By passwordField = By.cssSelector("input[type='password']");
    //private final By submitBtn = By.cssSelector("button[type='submit']");
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

   // public void provideEmail(String email){ findElement(emailField).sendKeys(email);}
    //public void providePassword(String password) { findElement(passwordField).sendKeys(password);}

    //public void clickSubmit() {findElement(submitBtn).click();}
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy (css = "[type='submit']")
    private WebElement submit;
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;}
    public LoginPage clickSubmit() {
        submit.click();
        return this;
    }
    public LoginPage login() {



        provideEmail("liudmila.chernyh@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        return this;

    }
}


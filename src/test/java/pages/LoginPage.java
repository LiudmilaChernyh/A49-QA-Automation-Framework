package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage{
    private final By emailField = By.cssSelector("input[type='email']");
    public final By passwordField = By.cssSelector("input[type='password']");
    private final By submitBtn = By.cssSelector("button[type='submit']");
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void provideEmail(String email){ findElement(emailField).sendKeys(email);}
    public void providePassword(String password) { findElement(passwordField).sendKeys(password);}

    public void clickSubmit() {findElement(submitBtn).click();}

    public void  login() throws InterruptedException {

        provideEmail("liudmila.chernyh@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();


    }
}


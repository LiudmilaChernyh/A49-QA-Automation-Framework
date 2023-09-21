package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.sql.DriverManager.getDriver;


public class LoginPage extends BasePage {
    WebDriverWait wait;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @FindBy (css ="input[type='email']")
    WebElement emailField;
    @FindBy (css ="input[type='password']")
    WebElement passwordField;
    @FindBy (css ="[type='submit']")
    WebElement submitBtn;
    @FindBy(xpath = "//a[@href='registration']")
     WebElement registrationLink;
    @FindBy(css = ".fa-sign-out")
     WebElement logOutLocator;

    public boolean isDisplaidLink (){
        return registrationLink.isDisplayed();

    }


    public void loginCorrectCred() {
        provideEmail("liudmila.chernyh@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();


    }

    public LoginPage provideEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).clear();
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }
    public WebElement getRegistrationLink() {
        return registrationLink;
    }
    public LoginPage clicklogOut() {
        logOutLocator.click();
        return this;
    }

}


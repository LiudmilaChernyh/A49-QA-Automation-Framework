import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.testng.Assert;

public class InvalidLoginTests extends BaseTest{
    LoginPage loginPage;
    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(driver);
        driver.get(url);
    }
    @Test
    public void invalidPasswordEmail(){
        loginPage.provideEmail("incorrectEmail").providePassword("incorrectPwd").clickSubmit();
        Assert.assertTrue(loginPage.isDisplaidLink());

    }
    @Test
    public void emptyEmail(){
        loginPage.provideEmail("").providePassword("incorrectPwd").clickSubmit();
        Assert.assertTrue(loginPage.isDisplaidLink());
    }
    @Test
    public void emptyEmailPassword(){
        loginPage.provideEmail("").providePassword("").clickSubmit();
        Assert.assertTrue(loginPage.isDisplaidLink());
    }

}
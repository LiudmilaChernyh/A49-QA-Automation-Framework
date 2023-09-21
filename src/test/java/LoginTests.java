import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import org.testng.Assert;

public class LoginTests extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;


    @BeforeMethod
    void setup(){
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        driver.get(url);


    }
    @Test
    public void validLogin(){
        loginPage.loginCorrectCred();
        Assert.assertTrue(homePage.getUserAvatar());

    }

}

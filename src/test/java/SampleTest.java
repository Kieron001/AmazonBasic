package test.java;

import main.java.pageEvents.HomePage;
import main.java.pageEvents.LoginPage;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test
    public void sampleMethodForEmailEntering()
    {
        HomePage homePage = new HomePage();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage();
        loginPage.verifyLoginPageOpenedorNot();
        loginPage.enterEmailId();

    }

}

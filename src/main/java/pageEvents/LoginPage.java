package main.java.pageEvents;

import main.java.pageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.testng.Assert;
import test.java.BaseTest;

public class LoginPage {

    //@Test
    public void verifyLoginPageOpenedorNot() // by checking if "Sign In" text present
    {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Verifying that the Login Page is opened or not");
        Assert.assertTrue(elementFetch.getListOfWebElements("XPATH", LoginPageElements.loginText).size()>0,
                "Login page did not open");

    }

    //@Test
    public void enterEmailId()
    {
        ElementFetch elementFetch = new ElementFetch();
        BaseTest.logger.info("Entering the email id");
        elementFetch.getWebElement("XPATH", LoginPageElements.emailAddress).sendKeys("kirankumar141292@gmail.com");

    }
}
